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

import com.northsoft.modules.worker.entity.LgWorkerAreaInfoEntity;
import com.northsoft.modules.worker.service.LgWorkerAreaInfoService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 区域信息
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkerareainfo")
public class LgWorkerAreaInfoController {
    @Autowired
    private LgWorkerAreaInfoService lgWorkerAreaInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkerareainfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerAreaInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{areaId}")
    @RequiresPermissions("worker:lgworkerareainfo:info")
    public R info(@PathVariable("areaId") Integer areaId){
        LgWorkerAreaInfoEntity lgWorkerAreaInfo = lgWorkerAreaInfoService.getById(areaId);

        return R.ok().put("lgWorkerAreaInfo", lgWorkerAreaInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkerareainfo:save")
    public R save(@RequestBody LgWorkerAreaInfoEntity lgWorkerAreaInfo){
        lgWorkerAreaInfoService.save(lgWorkerAreaInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkerareainfo:update")
    public R update(@RequestBody LgWorkerAreaInfoEntity lgWorkerAreaInfo){
        ValidatorUtils.validateEntity(lgWorkerAreaInfo);
        lgWorkerAreaInfoService.updateById(lgWorkerAreaInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkerareainfo:delete")
    public R delete(@RequestBody Integer[] areaIds){
        lgWorkerAreaInfoService.removeByIds(Arrays.asList(areaIds));

        return R.ok();
    }

}
