package com.northsoft.common.constants;

public enum RedisKeyEnum {

    WX_OPENID_LOGIN_TOKEN("00001", "wx:openid:{}:login:token"),
    ;


    private String code;
    private String msg;

    RedisKeyEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据编码查询key信息
     *
     * @param code
     * @return
     */
    public static RedisKeyEnum getKeyInfo(String code) {
        for (RedisKeyEnum redisKeyEnum : values()) {
            if (redisKeyEnum.getCode().equals(code)) {
                return redisKeyEnum;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
