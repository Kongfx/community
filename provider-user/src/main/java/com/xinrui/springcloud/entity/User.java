package com.xinrui.springcloud.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("t_user")
@Data
public class User extends Model<User> {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
