package com.xinrui.admin.dto;

import com.xinrui.admin.entity.Role;
import lombok.Data;

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
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 登陆账号
     */
    private String loginName;
    /**
     * 密码加盐
     */
    private String salt;
    /**
     * 密码
     */
    /**
     * 手机号
     */
    private Long mobile;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 登陆错误次数
     */
    private Integer loginErrTimes;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
    *  角色
    */
    private Set<Role> roles;

}
