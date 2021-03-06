package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户服务内容
 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_worker_content")
public class LgWorkerContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户服务关系id
	 */
	@TableId
	private Integer userTagId;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 服务内容
	 */
	private String contentDesc;
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
