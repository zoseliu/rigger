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

import com.northsoft.modules.worker.entity.LgWorkerAreaEntity;
import com.northsoft.modules.worker.service.LgWorkerAreaService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 用户区域关系
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkerarea")
public class LgWorkerAreaController {
    @Autowired
    private LgWorkerAreaService lgWorkerAreaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkerarea:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerAreaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userAreaId}")
    @RequiresPermissions("worker:lgworkerarea:info")
    public R info(@PathVariable("userAreaId") Integer userAreaId){
        LgWorkerAreaEntity lgWorkerArea = lgWorkerAreaService.getById(userAreaId);

        return R.ok().put("lgWorkerArea", lgWorkerArea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkerarea:save")
    public R save(@RequestBody LgWorkerAreaEntity lgWorkerArea){
        lgWorkerAreaService.save(lgWorkerArea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkerarea:update")
    public R update(@RequestBody LgWorkerAreaEntity lgWorkerArea){
        ValidatorUtils.validateEntity(lgWorkerArea);
        lgWorkerAreaService.updateById(lgWorkerArea);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkerarea:delete")
    public R delete(@RequestBody Integer[] userAreaIds){
        lgWorkerAreaService.removeByIds(Arrays.asList(userAreaIds));

        return R.ok();
    }

}
