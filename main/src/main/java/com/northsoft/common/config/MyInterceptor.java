package com.northsoft.common.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.northsoft.common.constants.RedisKeyEnum;
import com.northsoft.common.utils.R;
import com.northsoft.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle被调用");

        String redisKey = StrUtil.format(RedisKeyEnum.WX_OPENID_LOGIN_TOKEN.getMsg(), request.getParameter("openid"));

        String session_key = request.getParameter("session_key");

        if (StrUtil.isNotBlank(session_key) && session_key.equals(redisUtils.get(redisKey))) {
            return true;    //如果false，停止流程，api被拦截
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.write(JSONUtil.toJsonStr(R.error("please login again!")));
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle被调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion被调用");
    }
}
