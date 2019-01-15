package com.xinrui.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@GetMapping({"/",""})
	public String index(Model model){

		return "index";
	}

	@RequestMapping("login")
	public String login(Model model){
		return "login";
	}

	@RequestMapping("shiro")
	public String shiro(Model model){
		return "shiro";
	}
}
