package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgWorkerTagInfoDao;
import com.northsoft.modules.worker.entity.LgWorkerTagInfoEntity;
import com.northsoft.modules.worker.service.LgWorkerTagInfoService;


@Service("lgWorkerTagInfoService")
public class LgWorkerTagInfoServiceImpl extends ServiceImpl<LgWorkerTagInfoDao, LgWorkerTagInfoEntity> implements LgWorkerTagInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerTagInfoEntity> page = this.page(
                new Query<LgWorkerTagInfoEntity>().getPage(params),
                new QueryWrapper<LgWorkerTagInfoEntity>()
        );

        return new PageUtils(page);
    }

}
