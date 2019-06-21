package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgWorkerRatesDao;
import com.northsoft.modules.worker.entity.LgWorkerRatesEntity;
import com.northsoft.modules.worker.service.LgWorkerRatesService;


@Service("lgWorkerRatesService")
public class LgWorkerRatesServiceImpl extends ServiceImpl<LgWorkerRatesDao, LgWorkerRatesEntity> implements LgWorkerRatesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerRatesEntity> page = this.page(
                new Query<LgWorkerRatesEntity>().getPage(params),
                new QueryWrapper<LgWorkerRatesEntity>()
        );

        return new PageUtils(page);
    }

}
