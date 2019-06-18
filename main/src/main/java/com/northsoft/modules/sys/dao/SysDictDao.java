

package com.northsoft.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsoft.modules.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}
