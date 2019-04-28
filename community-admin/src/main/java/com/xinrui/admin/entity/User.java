package com.xinrui.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 * User basic infomation
 * </p>
 *
 * @author kongfx
 * @since 2019-04-28
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 登陆账号
     */
    @TableField("LOGIN_NAME")
    private String loginName;
    /**
     * 密码加盐
     */
    @TableField("SALT")
    private String salt;
    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;
    /**
     * 手机号
     */
    @TableField("MOBILE")
    private Long mobile;
    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;
    /**
     * 登陆错误次数
     */
    @TableField("LOGIN_ERR_TIMES")
    private Integer loginErrTimes;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;
    /**
     * 操作人id
     */
    @TableField("CREATE_BY")
    private Long createBy;
    /**
     * 更新时间
     */
    @TableField("LASTUPDATE_TIME")
    private Date lastupdateTime;
    /**
     * 修改操作人id
     */
    @TableField("LASTUPDATE_BY")
    private Long lastupdateBy;


    /**
     * 角色
     */
    private Set<Role> roles;

}
