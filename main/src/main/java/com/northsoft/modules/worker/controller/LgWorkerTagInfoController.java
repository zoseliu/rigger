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

import com.northsoft.modules.worker.entity.LgWorkerTagInfoEntity;
import com.northsoft.modules.worker.service.LgWorkerTagInfoService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 标签信息
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkertaginfo")
public class LgWorkerTagInfoController {
    @Autowired
    private LgWorkerTagInfoService lgWorkerTagInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkertaginfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerTagInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tagId}")
    @RequiresPermissions("worker:lgworkertaginfo:info")
    public R info(@PathVariable("tagId") Integer tagId){
        LgWorkerTagInfoEntity lgWorkerTagInfo = lgWorkerTagInfoService.getById(tagId);

        return R.ok().put("lgWorkerTagInfo", lgWorkerTagInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkertaginfo:save")
    public R save(@RequestBody LgWorkerTagInfoEntity lgWorkerTagInfo){
        lgWorkerTagInfoService.save(lgWorkerTagInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkertaginfo:update")
    public R update(@RequestBody LgWorkerTagInfoEntity lgWorkerTagInfo){
        ValidatorUtils.validateEntity(lgWorkerTagInfo);
        lgWorkerTagInfoService.updateById(lgWorkerTagInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkertaginfo:delete")
    public R delete(@RequestBody Integer[] tagIds){
        lgWorkerTagInfoService.removeByIds(Arrays.asList(tagIds));

        return R.ok();
    }

}
