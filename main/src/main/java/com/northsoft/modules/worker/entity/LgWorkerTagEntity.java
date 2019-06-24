package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户标签关系
 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_worker_tag")
public class LgWorkerTagEntity implements Serializable {
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
	 * 服务id
	 */
	private Integer tagId;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
