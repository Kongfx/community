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
 * DEPT
 * </p>
 *
 * @author kongfx
 * @since 2019-04-28
 */
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 部门名称
     */
    @TableField("DEPT_NAME")
    private String deptName;
    /**
     * 部门标识
     */
    @TableField("DEPT_SING")
    private String deptSing;
    /**
     * 说明
     */
    @TableField("REMARK")
    private String remark;
    /**
     * 上级部门
     */
    @TableField("P_DEPT_ID")
    private Long pDeptId;
    /**
     * 状态
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
