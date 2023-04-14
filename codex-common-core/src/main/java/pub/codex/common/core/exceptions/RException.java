package pub.codex.common.core.exceptions;

/**
 * 自定义异常
 */
public class RException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code = CodeDefined.ERROR.getValue();
    private String msg;

    public RException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RException(String msg, Integer code) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RException(String msg, Integer code, Throwable e) {
        super(msg, e);
        this.code = code;
        this.msg = msg;
    }

    public RException(CodeDefined codeDefined) {
        super(codeDefined.getDesc());
        this.code = codeDefined.getValue();
        this.msg = codeDefined.getDesc();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}