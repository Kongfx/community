package com.xinrui.springcloud.pojo;

import lombok.*;

import java.util.Date;
@Data
public class UserInfo {

    private Long id;
    private Date date;
    private String msg;

    public UserInfo(Long id){
        this.id = id;
        this.date = new Date();
        this.msg = "provider";
    }
}
