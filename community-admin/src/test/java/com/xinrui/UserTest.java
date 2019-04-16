package com.xinrui;

import com.xinrui.admin.dto.User;
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
	@Before
	public void shouldAnswerWithTrue()
	{
		assertTrue( true );
	}
	@Autowired
	private UserService userService;

	@Test
	public void testFindByName(){
		User user = userService.findByUsername("admin");
	}

}
