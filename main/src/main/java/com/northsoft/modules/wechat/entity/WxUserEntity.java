package com.northsoft.modules.wechat.entity;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author quchao123
 * @since 2019-06-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("wx_user")
public class WxUserEntity extends Model<WxUserEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 微信用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long user_id;
    /**
     * 微信openid
     */
    private String openid;
    /**
     * 用户昵称
     */
    private String nick_name;
    /**
     * 用户头像地址
     */
    private String image_addr;
    /**
     * 性别(1:男 2:女 3:未知)
     */
    private String sex;
    /**
     * 用户服务区域
     */
    private String user_area;
    /**
     * 联系电话
     */
    private String phone_num;
    /**
     * 用户类型(1:雇主 2:零工)
     */
    private String user_type;
    /**
     * 用户简介
     */
    private String user_intro;
    /**
     * 状态(0:正常 1:非正常)
     */
    private String status;
    /**
     * 创建时间
     */
    private Date create_time;


    @Override
    protected Serializable pkVal() {
        return this.user_id;
    }

}
