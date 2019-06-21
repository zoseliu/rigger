package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgWorkerImageDao;
import com.northsoft.modules.worker.entity.LgWorkerImageEntity;
import com.northsoft.modules.worker.service.LgWorkerImageService;


@Service("lgWorkerImageService")
public class LgWorkerImageServiceImpl extends ServiceImpl<LgWorkerImageDao, LgWorkerImageEntity> implements LgWorkerImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerImageEntity> page = this.page(
                new Query<LgWorkerImageEntity>().getPage(params),
                new QueryWrapper<LgWorkerImageEntity>()
        );

        return new PageUtils(page);
    }

}
