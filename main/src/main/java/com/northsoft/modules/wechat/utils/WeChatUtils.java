package com.northsoft.modules.wechat.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.setting.dialect.Props;

import java.util.HashMap;

public class WeChatUtils {

    static Props props = new Props("config.properties");

    //初始化秘钥
    public static final String APPID = props.getProperty("wechat.appid");
    public static final String SECRET = props.getProperty("wechat.secret");

    /**
     * 登录凭证校验
     *
     * @param code
     * @return
     */
    public static String jscode2session(String code) {

        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("appid", APPID);
        paramMap.put("secret", SECRET);
        paramMap.put("js_code", code);
        paramMap.put("grant_type", "authorization_code");
        String result = HttpUtil.get("https://api.weixin.qq.com/sns/jscode2session", paramMap);

        return result;
    }
}
