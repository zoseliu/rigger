package com.northsoft.modules.worker.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsoft.modules.worker.entity.LgWorkerInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 零工用户信息
 *
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Mapper
public interface LgWorkerInfoDao extends BaseMapper<LgWorkerInfoEntity> {

    LgWorkerInfoEntity queryByOpenId(String paramKey);

}
