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
 * MENU
 * </p>
 *
 * @author kongfx
 * @since 2019-04-28
 */
@Data
@Accessors(chain = true)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField("P_ID")
    private String pId;
    /**
     * 菜单名称
     */
    @TableField("MENU_NAME")
    private String menuName;
    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @TableField("TYPE")
    private String type;
    /**
     * 菜单URL
     */
    @TableField("URL")
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    @TableField("PERMISSION")
    private String permission;
    /**
     * 菜单图标
     */
    @TableField("ICON")
    private String icon;
    /**
     * 排序
     */
    @TableField("ORDER_NUM")
    private Integer orderNum;
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
