package com.northsoft.modules.worker.controller;

import java.util.Arrays;
import java.util.Map;

import com.northsoft.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.northsoft.modules.worker.entity.LgEmployerInfoEntity;
import com.northsoft.modules.worker.service.LgEmployerInfoService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 雇主用户信息
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgemployerinfo")
public class LgEmployerInfoController {
    @Autowired
    private LgEmployerInfoService lgEmployerInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgemployerinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgEmployerInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("worker:lgemployerinfo:info")
    public R info(@PathVariable("userId") Integer userId){
        LgEmployerInfoEntity lgEmployerInfo = lgEmployerInfoService.getById(userId);

        return R.ok().put("lgEmployerInfo", lgEmployerInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgemployerinfo:save")
    public R save(@RequestBody LgEmployerInfoEntity lgEmployerInfo){
        lgEmployerInfoService.save(lgEmployerInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgemployerinfo:update")
    public R update(@RequestBody LgEmployerInfoEntity lgEmployerInfo){
        ValidatorUtils.validateEntity(lgEmployerInfo);
        lgEmployerInfoService.updateById(lgEmployerInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgemployerinfo:delete")
    public R delete(@RequestBody Integer[] userIds){
        lgEmployerInfoService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
