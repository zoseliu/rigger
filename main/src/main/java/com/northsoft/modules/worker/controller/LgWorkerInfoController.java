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

import com.northsoft.modules.worker.entity.LgWorkerInfoEntity;
import com.northsoft.modules.worker.service.LgWorkerInfoService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 零工用户信息
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkerinfo")
public class LgWorkerInfoController {
    @Autowired
    private LgWorkerInfoService lgWorkerInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkerinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("worker:lgworkerinfo:info")
    public R info(@PathVariable("userId") Integer userId){
        LgWorkerInfoEntity lgWorkerInfo = lgWorkerInfoService.getById(userId);

        return R.ok().put("lgWorkerInfo", lgWorkerInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkerinfo:save")
    public R save(@RequestBody LgWorkerInfoEntity lgWorkerInfo){
        lgWorkerInfoService.save(lgWorkerInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkerinfo:update")
    public R update(@RequestBody LgWorkerInfoEntity lgWorkerInfo){
        ValidatorUtils.validateEntity(lgWorkerInfo);
        lgWorkerInfoService.updateById(lgWorkerInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkerinfo:delete")
    public R delete(@RequestBody Integer[] userIds){
        lgWorkerInfoService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
