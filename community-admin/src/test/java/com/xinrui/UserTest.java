package com.xinrui;

import com.xinrui.admin.config.ShiroKit;
import com.xinrui.admin.dao.UserMapper;
import com.xinrui.admin.entity.User;
import com.xinrui.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * @ClassName UserTest
 * @Description TODO
 * @Author kong
 * @Date 2019/2/20 11:03
 * @Version 1.0
 */
//@SpringBootTest(classes={com.xinrui.CommunityAdminApp.class})
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserTest {

	public static void main(String[] args) {
//		User user = new User();
//		user.setLoginName("admin");
//		String salt = ShiroKit.getRandomSalt(5);
//		user.setSalt(salt);
//		user.setStatus(0);
//		user.setPassword(ShiroKit.md5("123456",salt));
//		System.out.println("user:"+user);
	}

	@Before
	public void shouldAnswerWithTrue()
	{
		assertTrue( true );
	}
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;

	@Test
	public void addAdminUserInfo(){
		User user = new User();
		user.setLoginName("kongfx");
		String salt = ShiroKit.getRandomSalt(5);
		user.setSalt(salt);
		user.setStatus(0);
		user.setMobile(133555566666L);
		user.setPassword(ShiroKit.md5("123456","admin"+salt));
		System.out.println("user:"+user);
		userService.insert(user);
	}


	@Test
	public void testFindByName(){
		User user = userMapper.selectUserAndRolesByName("admin");
		System.out.println(user);
	}

}
