package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收费标准
 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_worker_rates")
public class LgWorkerRatesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * rates_id
	 */
	@TableId
	private Integer ratesId;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 收费标准类型(1:服务条目 2:销售配件)
	 */
	private String ratesType;
	/**
	 * 收费名称
	 */
	private String ratesName;
	/**
	 * 收费标准
	 */
	private String ratesDesc;
	/**
	 * 价格:单位分
	 */
	private Long price;
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
