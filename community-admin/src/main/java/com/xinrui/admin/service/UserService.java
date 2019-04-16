package com.xinrui.admin.service;

import com.xinrui.admin.dto.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 后台管理用户表 服务类
 * </p>
 *
 * @author kongfx
 * @since 2019-02-21
 */
public interface UserService extends IService<User> {

	User findByUsername(String username);

	void addAge();
}
