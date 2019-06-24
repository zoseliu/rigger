package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgWorkerAreaInfoDao;
import com.northsoft.modules.worker.entity.LgWorkerAreaInfoEntity;
import com.northsoft.modules.worker.service.LgWorkerAreaInfoService;


@Service("lgWorkerAreaInfoService")
public class LgWorkerAreaInfoServiceImpl extends ServiceImpl<LgWorkerAreaInfoDao, LgWorkerAreaInfoEntity> implements LgWorkerAreaInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgWorkerAreaInfoEntity> page = this.page(
                new Query<LgWorkerAreaInfoEntity>().getPage(params),
                new QueryWrapper<LgWorkerAreaInfoEntity>()
        );

        return new PageUtils(page);
    }

}
