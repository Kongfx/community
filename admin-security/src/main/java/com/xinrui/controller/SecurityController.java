package com.xinrui.controller;

import lombok.extern.slf4j.Slf4j;
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

	@RequestMapping("/login/error")
	public ModelAndView loginError(){
		return new ModelAndView("login_error");
	}

	@RequestMapping("/login/success")
	public ModelAndView loginSuccess(){
		return new ModelAndView("index222");
	}
}
