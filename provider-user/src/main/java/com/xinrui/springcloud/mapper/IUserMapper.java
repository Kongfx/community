package com.xinrui.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinrui.springcloud.entity.User;

import java.util.List;

public interface IUserMapper extends BaseMapper<User> {
    List<User> selectPermList(Page page);
}
