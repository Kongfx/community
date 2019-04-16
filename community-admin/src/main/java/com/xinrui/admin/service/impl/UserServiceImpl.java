package com.xinrui.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xinrui.admin.dao.UserMapper;
import com.xinrui.admin.dto.User;
import com.xinrui.admin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 后台管理用户表 服务实现类
 * </p>
 *
 * @author kongfx
 * @since 2019-02-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Override
	public User findByUsername(String username) {
		return selectOne(new EntityWrapper<User>().eq("username",username));
	}

	@Override
	@Transactional
	public void addAge() {
		User user = selectById(10);
		user.setAge(user.getAge() + 1);
		updateById(user);
		System.out.println(user);
	}
}
