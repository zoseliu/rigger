package com.northsoft.modules.worker.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.constants.RedisKeyEnum;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;
import com.northsoft.common.utils.RedisUtils;
import com.northsoft.modules.worker.dao.LgWorkerInfoDao;
import com.northsoft.modules.worker.entity.LgWorkerInfoEntity;
import com.northsoft.modules.worker.service.LgWorkerInfoService;
import com.northsoft.modules.worker.utils.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("lgWorkerInfoService")
public class LgWorkerInfoServiceImpl extends ServiceImpl<LgWorkerInfoDao, LgWorkerInfoEntity> implements LgWorkerInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerInfoEntity> page = this.page(
                new Query<LgWorkerInfoEntity>().getPage(params),
                new QueryWrapper<LgWorkerInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public String login(String code) {
        String json = WeChatUtils.jscode2session(code);

        if (0 == JSONUtil.parseObj(json).getInt("errcode")) {
            String openid = (String) JSONUtil.parseObj(json).get("openid");
            String session_key = (String) JSONUtil.parseObj(json).get("session_key");

            LgWorkerInfoEntity entity = baseMapper.queryByOpenId(openid);
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
    public void updateuser(LgWorkerInfoEntity lgWorkerInfoEntity) {
        baseMapper.update(lgWorkerInfoEntity, new UpdateWrapper<LgWorkerInfoEntity>().eq("openid", lgWorkerInfoEntity.getOpenid()));
    }

    @Override
    public void logout(String openid) {
        String redisKey = StrUtil.format(RedisKeyEnum.WX_OPENID_LOGIN_TOKEN.getMsg(), openid);
        redisUtils.delete(redisKey);
    }


}
