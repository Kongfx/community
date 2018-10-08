package com.xinrui.springcloud.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xinrui.springcloud.entity.User;
import com.xinrui.springcloud.mapper.IUserMapper;
import com.xinrui.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {

    @Autowired
    IUserMapper iUserMapper;
}
