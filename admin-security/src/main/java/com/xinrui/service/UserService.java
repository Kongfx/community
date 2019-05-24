package com.xinrui.service;

import com.baomidou.mybatisplus.service.IService;
import com.xinrui.entity.User;

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
