package com.xinrui.admin.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author kongfx
 * @since 2019-01-12
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 自我介绍
     */
    private String aboutme;
    /**
     * 经过MD5加密的密码
     */
    private String passwd;
    /**
     * 头像图片
     */
    private String avatar;
    /**
     * 1:普通用户，2:房产经纪人
     */
    private Integer type;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 是否启用,1启用，0停用
     */
    private Integer enable;
    /**
     * 所属经纪机构
     */
    @TableField("agency_id")
    private Integer agencyId;


}
