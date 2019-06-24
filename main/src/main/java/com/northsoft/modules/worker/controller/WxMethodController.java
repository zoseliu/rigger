package com.northsoft.modules.worker.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.northsoft.common.utils.LogPrint;
import com.northsoft.common.utils.R;
import com.northsoft.modules.worker.entity.LgWorkerInfoEntity;
import com.northsoft.modules.worker.service.LgWorkerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@RequestMapping(value = "/wx")
public class WxMethodController extends LogPrint {

    @Autowired
    private LgWorkerInfoService lgWorkerInfoService;

    /**
     * 登录凭证校验
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public R login(@RequestBody Map<String, Object> param) {

        String code = StrUtil.toString(param.get("code"));
        logger.info("params===>>>" + code);

        return R.ok().put("json", lgWorkerInfoService.login(code));
    }

    /**
     * 更新用户信息
     */
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    @ResponseBody
    public R updateuser(@RequestBody Map<String, Object> param) {

        LgWorkerInfoEntity entity = BeanUtil.mapToBean(param, LgWorkerInfoEntity.class, true);
        lgWorkerInfoService.updateuser(entity);

        return R.ok();
    }

    /**
     * 登出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public R logout(@RequestBody Map<String, Object> param) {

        String openid = StrUtil.toString(param.get("openid"));
        logger.info("params===>>>" + openid);

        lgWorkerInfoService.logout(openid);

        return R.ok();
    }

}
