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

import com.northsoft.modules.worker.entity.LgWorkerRatesEntity;
import com.northsoft.modules.worker.service.LgWorkerRatesService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 用户收费标准
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgworkerrates")
public class LgWorkerRatesController {
    @Autowired
    private LgWorkerRatesService lgWorkerRatesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgworkerrates:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgWorkerRatesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{ratesId}")
    @RequiresPermissions("worker:lgworkerrates:info")
    public R info(@PathVariable("ratesId") Integer ratesId){
        LgWorkerRatesEntity lgWorkerRates = lgWorkerRatesService.getById(ratesId);

        return R.ok().put("lgWorkerRates", lgWorkerRates);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgworkerrates:save")
    public R save(@RequestBody LgWorkerRatesEntity lgWorkerRates){
        lgWorkerRatesService.save(lgWorkerRates);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgworkerrates:update")
    public R update(@RequestBody LgWorkerRatesEntity lgWorkerRates){
        ValidatorUtils.validateEntity(lgWorkerRates);
        lgWorkerRatesService.updateById(lgWorkerRates);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgworkerrates:delete")
    public R delete(@RequestBody Integer[] ratesIds){
        lgWorkerRatesService.removeByIds(Arrays.asList(ratesIds));

        return R.ok();
    }

}
