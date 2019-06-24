package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域信息
 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_worker_area_info")
public class LgWorkerAreaInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * area_id
	 */
	@TableId
	private Integer areaId;
	/**
	 * 服务区域
	 */
	private String areaName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 是否删除(0:未删除 1:已删除)
	 */
	private String isDelete;

}
