package com.xinrui.service;

import com.xinrui.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyUserDetailsService
 * @Description TODO
 * @Author kong
 * @Date 2019/4/24 15:20
 * @Version 1.0
 */
@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("表单登录用户名 username={}",username);
//		return buildUser(username);
		User user = userService.findByUsername(username);
		return user;
	}

//	private User buildUser(String username) {
//		// 根据用户名查找用户信息
//		//根据查找到的用户信息判断用户是否被冻结
//		String password = passwordEncoder.encode("123456");
//		log.info("数据库密码是:"+password);
//		return new User(username, password,
//				true, true, true, true,
//				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//	}
}
