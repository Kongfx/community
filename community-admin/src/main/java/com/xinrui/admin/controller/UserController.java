package com.xinrui.admin.controller;


import com.xinrui.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台管理用户表 前端控制器
 * </p>
 *
 * @author kongfx
 * @since 2019-02-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(name="/addAge",method = RequestMethod.GET)
	public void addAge(){
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				userService.addAge();
				System.err.println(Thread.currentThread().getName());
			});
		}
	}
}

