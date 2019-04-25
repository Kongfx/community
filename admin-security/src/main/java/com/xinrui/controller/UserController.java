package com.xinrui.controller;

import com.xinrui.dto.UserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserInfoController
 * @Description TODO
 * @Author kong
 * @Date 2019/4/24 13:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/currentUser")
	public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
//	public Object getCurrentUser(Authentication authentication){
//	public Object getCurrentUser(){
		return userDetails;
//		return authentication;
//		return SecurityContextHolder.getContext().getAuthentication();
	}

	@GetMapping
	public List<UserInfo> query(@RequestParam(required = false) String UserInfoname){
		List<UserInfo> list = new ArrayList<UserInfo>();
		list.add(new UserInfo());
		list.add(new UserInfo());
		list.add(new UserInfo());
		return list;
	}

	@GetMapping("/{id:\\d+}")//可以添加正则来限制参数类型，有啥用？？？？
	public UserInfo getById(@PathVariable Long id){
		return new UserInfo(id,"tom","123");
	}

	@PostMapping
	public UserInfo create(@RequestBody UserInfo UserInfo){
		System.out.println(UserInfo.getUsername());
		System.out.println(UserInfo.getPassword());
		System.out.println(UserInfo.getId());
		UserInfo.setId(1L);
		return UserInfo;
	}
}
