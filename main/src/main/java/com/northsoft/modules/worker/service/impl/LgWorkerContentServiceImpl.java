package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgWorkerContentDao;
import com.northsoft.modules.worker.entity.LgWorkerContentEntity;
import com.northsoft.modules.worker.service.LgWorkerContentService;


@Service("lgWorkerContentService")
public class LgWorkerContentServiceImpl extends ServiceImpl<LgWorkerContentDao, LgWorkerContentEntity> implements LgWorkerContentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerContentEntity> page = this.page(
                new Query<LgWorkerContentEntity>().getPage(params),
                new QueryWrapper<LgWorkerContentEntity>()
        );

        return new PageUtils(page);
    }

}
