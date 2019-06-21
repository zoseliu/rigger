package com.northsoft.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.modules.worker.entity.LgWorkerAreaEntity;

import java.util.Map;

/**
 * 用户区域关系
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
public interface LgWorkerAreaService extends IService<LgWorkerAreaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

