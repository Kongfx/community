package com.xinrui.admin.service;

import com.xinrui.admin.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * User basic infomation 服务类
 * </p>
 *
 * @author kongfx
 * @since 2019-04-28
 */
public interface UserService extends IService<User> {

	User findByUsername(String username);
}
