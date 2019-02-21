package com.xinrui.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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
	public String shiro(HttpServletRequest request, Model model, String username,String password){
		// 在认证提交前准备 token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		StringBuffer msg = null;
		// 执行认证登陆
		try {
			// 从SecurityUtils里边创建一个 subject
			SecurityUtils.getSubject().login(token);
			msg = new StringBuffer("登陆成功！");
		} catch (UnknownAccountException ex) {
			msg = new StringBuffer("账号：" + username + "，不存在！");
		} catch (IncorrectCredentialsException ex) {
			msg = new StringBuffer("账号：" + username + "，密码输入错误！");
		} catch (ExcessiveAttemptsException ex) {
			msg = new StringBuffer("账号：" + username + "，登录失败次数过多！");
		} catch (ExpiredCredentialsException ex) {
			msg = new StringBuffer("账号：" + username + "，凭证过期！");
		}catch (AuthenticationException es){
			msg = new StringBuffer("账号：" + username + "，凭证过期！");
		}
		model.addAttribute("msg",msg);
		return "shiro";
	}

}
