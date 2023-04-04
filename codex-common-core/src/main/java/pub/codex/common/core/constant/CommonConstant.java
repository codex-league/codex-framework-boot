package pub.codex.common.core.constant;

/**
 * 公共常量
 */
public class CommonConstant {


    /**
     * 是否有效
     */
    public enum IsActive implements IEnum<Integer, String> {
        TRUE(1, "有效"),
        FALSE(0, "无效");

        Integer value;
        String desc;

        IsActive(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public Integer getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }

        public static String getLocaleDesc(Integer value) {
            if (value != null) {
                for (IsActive str : IsActive.values()) {

                    if (str.value.intValue() == value.intValue()) {
                        return str.getDesc();
                    }
                }
            }

            return "";
        }
    }


}