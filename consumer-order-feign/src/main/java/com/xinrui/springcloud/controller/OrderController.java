package com.xinrui.springcloud.controller;

import com.xinrui.springcloud.pojo.OrderUser;
import com.xinrui.springcloud.service.OrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderUserService orderUserService;
    @GetMapping("/order/{id}")
    public OrderUser getOrderUserById(@PathVariable Long id){
        return  orderUserService.getOrderUserById(id);
    }

    @PostMapping("/order-user")
    public OrderUser getOrderUser(OrderUser user){
        OrderUser user1 = orderUserService.getUser(user);
        return user1;
    }

}
