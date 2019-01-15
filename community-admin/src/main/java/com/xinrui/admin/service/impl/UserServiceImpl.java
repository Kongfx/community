package com.xinrui.admin.service.impl;

import com.xinrui.admin.dto.User;
import com.xinrui.admin.dao.UserMapper;
import com.xinrui.admin.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kongfx
 * @since 2019-01-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private UserMapper userMapper;

}
