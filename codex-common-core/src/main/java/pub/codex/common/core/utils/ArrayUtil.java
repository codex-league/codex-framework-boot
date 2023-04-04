package pub.codex.common.core.utils;


import java.util.Arrays;

/**
 * 数组工具类
 */
public class ArrayUtil {



    /**
     * 按符号拼接
     *
     * @param regex       符号 eg: ","
     * @param sourceArray [a,b,c]
     * @return eg: a,b,c
     */
    public static String splicing(String regex, String... sourceArray) {

        StringBuffer stringBuffer = new StringBuffer();

        Arrays.stream(sourceArray).forEach(s -> {
            stringBuffer.append(s).append(regex);
        });

        return stringBuffer.toString().substring(0, stringBuffer.toString().length() - 1);
    }


    private ArrayUtil() {
    }
}
