package com.xinrui.admin.service.impl;

import com.xinrui.admin.service.SynchronizedService;
import com.xinrui.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SynchronizedServiceImpl
 * @Description TODO
 * @Author kong
 * @Date 2019/2/20 9:24
 * @Version 1.0
 */
@Service
public class SynchronizedServiceImpl implements SynchronizedService {
	@Autowired
	private UserService userService;

	@Override
	public synchronized void synchronizedAddAge() {
		userService.addAge();
	}
}
