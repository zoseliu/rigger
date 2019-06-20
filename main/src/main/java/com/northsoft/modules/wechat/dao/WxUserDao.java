package com.northsoft.modules.wechat.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsoft.modules.wechat.entity.WxUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author quchao123
 * @since 2019-06-19
 */
@Mapper
public interface WxUserDao extends BaseMapper<WxUserEntity> {

    WxUserEntity queryByOpenId(String paramKey);

}
