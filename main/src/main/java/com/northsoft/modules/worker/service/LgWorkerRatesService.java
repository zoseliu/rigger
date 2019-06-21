package com.northsoft.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.modules.worker.entity.LgWorkerRatesEntity;

import java.util.Map;

/**
 * 用户收费标准
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
public interface LgWorkerRatesService extends IService<LgWorkerRatesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

