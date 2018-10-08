package com.xinrui.springcloud.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderUser {
    private Long id;
    private Date date;
    private String msg;

    public OrderUser(Long id){
        this.id = id;
        this.date = new Date();
        this.msg = "order";
    }

}
