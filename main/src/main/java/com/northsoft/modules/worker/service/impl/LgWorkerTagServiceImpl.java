package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgWorkerTagDao;
import com.northsoft.modules.worker.entity.LgWorkerTagEntity;
import com.northsoft.modules.worker.service.LgWorkerTagService;


@Service("lgWorkerTagService")
public class LgWorkerTagServiceImpl extends ServiceImpl<LgWorkerTagDao, LgWorkerTagEntity> implements LgWorkerTagService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerTagEntity> page = this.page(
                new Query<LgWorkerTagEntity>().getPage(params),
                new QueryWrapper<LgWorkerTagEntity>()
        );

        return new PageUtils(page);
    }

}
