package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户证件照片
 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_worker_image")
public class LgWorkerImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户简介图片
	 */
	@TableId
	private Integer imageId;
	/**
	 * wxuser表中user_id
	 */
	private Integer userId;
	/**
	 * 图片地址
	 */
	private String imageAddr;
	/**
	 * 排序
	 */
	private Integer showOrder;
	/**
	 * 证件照类型(1:正面 2:背面 3:手持身份证 4:其他证件照 5:个人简介 6:服务内容)
	 */
	private String imageType;
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
