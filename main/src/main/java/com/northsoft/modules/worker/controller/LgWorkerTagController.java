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

import com.northsoft.modules.worker.entity.LgWorkerTagEntity;
import com.northsoft.modules.worker.service.LgWorkerTagService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 用户标签关系
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkertag")
public class LgWorkerTagController {
    @Autowired
    private LgWorkerTagService lgWorkerTagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkertag:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerTagService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userTagId}")
    @RequiresPermissions("worker:lgworkertag:info")
    public R info(@PathVariable("userTagId") Integer userTagId){
        LgWorkerTagEntity lgWorkerTag = lgWorkerTagService.getById(userTagId);

        return R.ok().put("lgWorkerTag", lgWorkerTag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkertag:save")
    public R save(@RequestBody LgWorkerTagEntity lgWorkerTag){
        lgWorkerTagService.save(lgWorkerTag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkertag:update")
    public R update(@RequestBody LgWorkerTagEntity lgWorkerTag){
        ValidatorUtils.validateEntity(lgWorkerTag);
        lgWorkerTagService.updateById(lgWorkerTag);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkertag:delete")
    public R delete(@RequestBody Integer[] userTagIds){
        lgWorkerTagService.removeByIds(Arrays.asList(userTagIds));

        return R.ok();
    }

}
