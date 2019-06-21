package com.northsoft.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.modules.worker.entity.LgWorkerInfoEntity;

import java.util.Map;

/**
 * 零工用户信息
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
public interface LgWorkerInfoService extends IService<LgWorkerInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    String login(String code);

    void updateuser(LgWorkerInfoEntity lgWorkerInfoEntity);

    void logout(String code);
}

