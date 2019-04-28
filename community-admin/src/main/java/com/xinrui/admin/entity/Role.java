package com.xinrui.admin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * ROLE
 * </p>
 *
 * @author kongfx
 * @since 2019-04-28
 */
@Data
@Accessors(chain = true)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;
    /**
     * 角色标识
     */
    @TableField("ROLE_SING")
    private String roleSing;
    /**
     * 说明
     */
    @TableField("REMARK")
    private String remark;
    /**
     * 是否可用
     */
    @TableField("STATUS")
    private Integer status;
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


}
