package com.xinrui.springcloud.controller;

import com.xinrui.springcloud.pojo.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public UserInfo getUserById(@PathVariable Long id){
        return new UserInfo(id);
    }

    @PostMapping("/get-user")
    public UserInfo getUser(UserInfo user){
        UserInfo pri_user = new UserInfo(user.getId()+100);
        return pri_user;
    }
}