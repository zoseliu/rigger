package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgEmployerInfoDao;
import com.northsoft.modules.worker.entity.LgEmployerInfoEntity;
import com.northsoft.modules.worker.service.LgEmployerInfoService;


@Service("lgEmployerInfoService")
public class LgEmployerInfoServiceImpl extends ServiceImpl<LgEmployerInfoDao, LgEmployerInfoEntity> implements LgEmployerInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgEmployerInfoEntity> page = this.page(
                new Query<LgEmployerInfoEntity>().getPage(params),
                new QueryWrapper<LgEmployerInfoEntity>()
        );

        return new PageUtils(page);
    }

}
