package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签信息
 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_worker_tag_info")
public class LgWorkerTagInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * service_id
	 */
	@TableId
	private Integer tagId;
	/**
	 * 服务类别(1:服务项目 2:服务工种)
	 */
	private String tagType;
	/**
	 * 服务名称
	 */
	private String tagName;
	/**
	 * 父id
	 */
	private Integer parentId;
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
