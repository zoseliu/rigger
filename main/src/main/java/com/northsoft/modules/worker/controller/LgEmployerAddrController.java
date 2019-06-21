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

import com.northsoft.modules.worker.entity.LgEmployerAddrEntity;
import com.northsoft.modules.worker.service.LgEmployerAddrService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.R;



/**
 * 雇主地址信息

 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@RestController
@RequestMapping("worker/lgemployeraddr")
public class LgEmployerAddrController {
    @Autowired
    private LgEmployerAddrService lgEmployerAddrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:lgemployeraddr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = lgEmployerAddrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{addrId}")
    @RequiresPermissions("worker:lgemployeraddr:info")
    public R info(@PathVariable("addrId") Integer addrId){
        LgEmployerAddrEntity lgEmployerAddr = lgEmployerAddrService.getById(addrId);

        return R.ok().put("lgEmployerAddr", lgEmployerAddr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:lgemployeraddr:save")
    public R save(@RequestBody LgEmployerAddrEntity lgEmployerAddr){
        lgEmployerAddrService.save(lgEmployerAddr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:lgemployeraddr:update")
    public R update(@RequestBody LgEmployerAddrEntity lgEmployerAddr){
        ValidatorUtils.validateEntity(lgEmployerAddr);
        lgEmployerAddrService.updateById(lgEmployerAddr);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:lgemployeraddr:delete")
    public R delete(@RequestBody Integer[] addrIds){
        lgEmployerAddrService.removeByIds(Arrays.asList(addrIds));

        return R.ok();
    }

}
