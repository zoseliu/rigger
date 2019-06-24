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

import com.northsoft.modules.worker.entity.LgWorkerImageEntity;
import com.northsoft.modules.worker.service.LgWorkerImageService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 用户证件照片
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkerimage")
public class LgWorkerImageController {
    @Autowired
    private LgWorkerImageService lgWorkerImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkerimage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerImageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{imageId}")
    @RequiresPermissions("worker:lgworkerimage:info")
    public R info(@PathVariable("imageId") Integer imageId){
        LgWorkerImageEntity lgWorkerImage = lgWorkerImageService.getById(imageId);

        return R.ok().put("lgWorkerImage", lgWorkerImage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkerimage:save")
    public R save(@RequestBody LgWorkerImageEntity lgWorkerImage){
        lgWorkerImageService.save(lgWorkerImage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkerimage:update")
    public R update(@RequestBody LgWorkerImageEntity lgWorkerImage){
        ValidatorUtils.validateEntity(lgWorkerImage);
        lgWorkerImageService.updateById(lgWorkerImage);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkerimage:delete")
    public R delete(@RequestBody Integer[] imageIds){
        lgWorkerImageService.removeByIds(Arrays.asList(imageIds));

        return R.ok();
    }

}
