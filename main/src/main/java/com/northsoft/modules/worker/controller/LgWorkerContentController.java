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

import com.northsoft.modules.worker.entity.LgWorkerContentEntity;
import com.northsoft.modules.worker.service.LgWorkerContentService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 用户服务内容
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkercontent")
public class LgWorkerContentController {
    @Autowired
    private LgWorkerContentService lgWorkerContentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkercontent:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerContentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userTagId}")
    @RequiresPermissions("worker:lgworkercontent:info")
    public R info(@PathVariable("userTagId") Integer userTagId){
        LgWorkerContentEntity lgWorkerContent = lgWorkerContentService.getById(userTagId);

        return R.ok().put("lgWorkerContent", lgWorkerContent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkercontent:save")
    public R save(@RequestBody LgWorkerContentEntity lgWorkerContent){
        lgWorkerContentService.save(lgWorkerContent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkercontent:update")
    public R update(@RequestBody LgWorkerContentEntity lgWorkerContent){
        ValidatorUtils.validateEntity(lgWorkerContent);
        lgWorkerContentService.updateById(lgWorkerContent);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkercontent:delete")
    public R delete(@RequestBody Integer[] userTagIds){
        lgWorkerContentService.removeByIds(Arrays.asList(userTagIds));

        return R.ok();
    }

}
