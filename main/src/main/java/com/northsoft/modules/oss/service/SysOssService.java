

package com.northsoft.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.northsoft.common.utils.PageUtils;
import com.northsoft.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
