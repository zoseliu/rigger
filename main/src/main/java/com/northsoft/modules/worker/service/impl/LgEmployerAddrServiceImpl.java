package com.northsoft.modules.worker.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.common.utils.Query;

import com.northsoft.modules.worker.dao.LgEmployerAddrDao;
import com.northsoft.modules.worker.entity.LgEmployerAddrEntity;
import com.northsoft.modules.worker.service.LgEmployerAddrService;


@Service("lgEmployerAddrService")
public class LgEmployerAddrServiceImpl extends ServiceImpl<LgEmployerAddrDao, LgEmployerAddrEntity> implements LgEmployerAddrService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LgEmployerAddrEntity> page = this.page(
                new Query<LgEmployerAddrEntity>().getPage(params),
                new QueryWrapper<LgEmployerAddrEntity>()
        );

        return new PageUtils(page);
    }

}
