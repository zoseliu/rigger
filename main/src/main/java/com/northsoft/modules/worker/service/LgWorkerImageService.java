package com.northsoft.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.modules.worker.entity.LgWorkerImageEntity;

import java.util.Map;

/**
 * 用户证件照片
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
public interface LgWorkerImageService extends IService<LgWorkerImageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

