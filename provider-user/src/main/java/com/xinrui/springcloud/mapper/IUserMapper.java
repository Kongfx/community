package com.xinrui.springcloud.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xinrui.springcloud.entity.User;

import java.util.List;

public interface IUserMapper extends BaseMapper<User> {
    List<User> selectPermList(Page page);
}
