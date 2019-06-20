package com.northsoft.modules.wechat.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.constants.RedisKeyEnum;
import com.northsoft.common.utils.RedisUtils;
import com.northsoft.modules.wechat.dao.WxUserDao;
import com.northsoft.modules.wechat.entity.WxUserEntity;
import com.northsoft.modules.wechat.service.WxUserService;
import com.northsoft.modules.wechat.utils.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author quchao123
 * @since 2019-06-19
 */
@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserDao, WxUserEntity> implements WxUserService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String login(String code) {
        String json = WeChatUtils.jscode2session(code);

        if (0 == JSONUtil.parseObj(json).getInt("errcode")) {
            String openid = (String) JSONUtil.parseObj(json).get("openid");
            String session_key = (String) JSONUtil.parseObj(json).get("session_key");

            WxUserEntity entity = baseMapper.queryByOpenId(openid);
            if (entity == null) {
                entity.setOpenid(openid);
                baseMapper.insert(entity);
            }

            String redisKey = StrUtil.format(RedisKeyEnum.WX_OPENID_LOGIN_TOKEN.getMsg(), openid);
            redisUtils.set(redisKey, session_key);
        }

        return json;
    }

    @Override
    public void updateuser(WxUserEntity wxUserEntity) {
        baseMapper.update(wxUserEntity, new UpdateWrapper<WxUserEntity>().eq("openid", wxUserEntity.getOpenid()));
    }

    @Override
    public void logout(String openid) {
            String redisKey = StrUtil.format(RedisKeyEnum.WX_OPENID_LOGIN_TOKEN.getMsg(), openid);
            redisUtils.delete(redisKey);
    }

    @Override
    public Long queryByOpenId(String openid) {

        WxUserEntity entity = baseMapper.queryByOpenId(openid);

        return entity == null ? null : entity.getUser_id();
    }

}
