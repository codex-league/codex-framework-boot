package pub.codex.common.core.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import pub.codex.common.core.utils.ArrayUtil;
import pub.codex.common.core.utils.StringUtils;
import pub.codex.common.result.R;
import pub.codex.common.result.RBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    public static final String MESSAGE = "message";

    /**
     * 自定义异常处理
     *
     * @param req
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = RException.class)
    @ResponseBody
    public R baseExceptionHandler(HttpServletRequest req, RException ex) throws Exception {
        return RBuilder.error(ex.getCode(), ex.getMsg());
    }

    /**
     * 404 异常处理
     *
     * @param req
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    public R noHandlerExceptionHandler(HttpServletRequest req, Exception ex) throws Exception {
        return RBuilder.error(CodeDefined.URL_NOT_FOUND.getValue(), CodeDefined.URL_NOT_FOUND.getDesc());
    }

    /**
     * 未知异常处理
     *
     * @param req
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R exceptionHandler(HttpServletRequest req, Exception ex) throws Exception {

        logger.error("未知异常:", ex);
        return RBuilder.error(CodeDefined.ERROR.getValue(), CodeDefined.ERROR.getDesc());
    }

    /**
     * 参数验证异常处理
     *
     * @param req
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public R parameterExceptionHandler(HttpServletRequest req, Exception ex) {
        List<Map<String, String>> resErrors = new ArrayList<>();
        List<ObjectError> errors = null;
        if (ex instanceof MethodArgumentNotValidException) {
            errors = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();
        } else if (ex instanceof BindException) {
            errors = ((BindException) ex).getBindingResult().getAllErrors();
        }

        for (ObjectError error : errors) {
            Map<String, String> result = new HashMap<>();
            result.put(MESSAGE, "未知的参数错误");

            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                String messageFormat = fieldError.getDefaultMessage();
//                String errorMessage = formatValidMessage(messageFormat, fieldError);
                String errorMessage = messageFormat;

                result.put("field", fieldError.getField());
                result.put(MESSAGE, errorMessage);

                String value = String.valueOf(fieldError.getRejectedValue());
                if (!StringUtils.isNulltoString(value)) {
                    result.put("value", value);
                }
            } else {
                result.put(MESSAGE, error.getDefaultMessage());
            }
            resErrors.add(result);
        }


        return RBuilder.tips(CodeDefined.ERROR_PARAMETER.getValue(), CodeDefined.ERROR_PARAMETER.getDesc(), resErrors);
    }


    /**
     * 请求参数语法错误
     *
     * @param req
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public R httpMessageNotReadableExceptionHandler(HttpServletRequest req, Exception ex) throws Exception {
        logger.error("json语法错误异常:", ex);
        return RBuilder.error(CodeDefined.ERROR_SYNTAX.getValue(), CodeDefined.ERROR_SYNTAX.getDesc());
    }


    /**
     * 请求方法错误
     *
     * @param req
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public R httpRequestMethodNotSupportedException(HttpServletRequest req, HttpRequestMethodNotSupportedException ex) throws Exception {
        logger.error("请求方法类型错误:", ex);
        return RBuilder.error(CodeDefined.METHOD_ERROR.getValue(), String.format(
                CodeDefined.METHOD_ERROR.getDesc(), ArrayUtil.splicing(",", ex.getSupportedMethods())));
    }

    /**
     * 非法数据异常
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public R illegalArgumentException(IllegalArgumentException ex) throws Exception {
        logger.error("非法数据异常:", ex);
        return RBuilder.build(CodeDefined.ILLEGAL_ARGUMENT.getValue(),
                String.format(CodeDefined.ILLEGAL_ARGUMENT.getDesc(),ex.getMessage()));
    }
}