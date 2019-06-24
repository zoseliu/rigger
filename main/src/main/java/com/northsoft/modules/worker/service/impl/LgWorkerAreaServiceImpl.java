package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgWorkerAreaDao;
import com.northsoft.modules.worker.entity.LgWorkerAreaEntity;
import com.northsoft.modules.worker.service.LgWorkerAreaService;


@Service("lgWorkerAreaService")
public class LgWorkerAreaServiceImpl extends ServiceImpl<LgWorkerAreaDao, LgWorkerAreaEntity> implements LgWorkerAreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerAreaEntity> page = this.page(
                new Query<LgWorkerAreaEntity>().getPage(params),
                new QueryWrapper<LgWorkerAreaEntity>()
        );

        return new PageUtils(page);
    }

}
