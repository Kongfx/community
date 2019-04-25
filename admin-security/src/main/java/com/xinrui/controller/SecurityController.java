package com.xinrui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName SecurityController
 * @Description TODO
 * @Author kong
 * @Date 2019/4/24 15:42
 * @Version 1.0
 */
@RestController
@Slf4j
public class SecurityController {

	@RequestMapping("/toLogin")
	public ModelAndView toLogin(){
		return new ModelAndView("login");
	}

	@PostMapping("/auth/from")
	public ModelAndView login(){
		return new ModelAndView("main");
	}
}
