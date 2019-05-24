package com.xinrui;

import com.xinrui.entity.User;
import com.xinrui.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName TestCURD
 * @Description TODO
 * @Author kong
 * @Date 2019/5/22 10:46
 * @Version 1.0
 */
public class TestCURD extends AdminSecurityApplicationTest {

	@Autowired
	private UserService userService;

	@Test
	public void test(){
		User user = userService.findByUsername("admin");
		System.out.println(user);
	}
}
