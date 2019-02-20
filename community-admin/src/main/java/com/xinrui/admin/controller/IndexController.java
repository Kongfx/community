package com.xinrui.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

	@GetMapping({"/","","/index"})
	public String index(Model model){
		return "index";
	}
	@GetMapping("/notLogin")
	public String notLogin(Model model){
		return "errorView/403";
	}

	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String login(HttpServletRequest request,Model model){
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String shiro(HttpServletRequest request, Model model){
		// 登录失败从request中获取shiro处理的异常信息。shiroLoginFailure:就是shiro异常类的全类名.
		Object exception = request.getAttribute("shiroLoginFailure");
		return "shiro";
	}

}
