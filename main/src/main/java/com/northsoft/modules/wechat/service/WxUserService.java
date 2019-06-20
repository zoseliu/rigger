package com.northsoft.modules.wechat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.northsoft.modules.wechat.entity.WxUserEntity;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author quchao123
 * @since 2019-06-19
 */
public interface WxUserService extends IService<WxUserEntity> {

    String login(String code);

    void updateuser(WxUserEntity wxUserEntity);

    void logout(String code);

    Long queryByOpenId(String openid);

}
