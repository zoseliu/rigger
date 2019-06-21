package com.northsoft.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 雇主用户信息
 * 
 * @author quchao
 * @email 42692108@qq.com
 * @date 2019-06-21 14:48:29
 */
@Data
@TableName("lg_employer_info")
public class LgEmployerInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 微信用户ID
	 */
	@TableId
	private Integer userId;
	/**
	 * 微信openid
	 */
	private String openid;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 状态(1:提交申请 0:申请完成)
	 */
	private String status;
	/**
	 * 用户头像地址
	 */
	private String imageAddr;
	/**
	 * 性别(1:男 2:女 3:未知)
	 */
	private String sex;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 是否删除(0:未删除 1:已删除)
	 */
	private String isDelete;

}
