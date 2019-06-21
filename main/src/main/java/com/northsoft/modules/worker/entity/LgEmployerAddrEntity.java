package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 雇主地址信息

 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_employer_addr")
public class LgEmployerAddrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * area_id
	 */
	@TableId
	private Integer addrId;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 街道名称
	 */
	private String street;
	/**
	 * 房间号
	 */
	private String roomNumber;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 联系方式
	 */
	private String phoneNum;
	/**
	 * 是否默认(1:是 0:否)
	 */
	private String isDefault;
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
