package com.xinrui.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinrui.enums.LoginResponseTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyAuthenticationFailHander
 * @Description TODO
 * @Author kong
 * @Date 2019/4/24 17:07
 * @Version 1.0
 */
@Component("myAuthenticationFailHander")
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		logger.info("登录失败");
		//TODO: 这里需要后期配置 请求方式 json 还是 跳转
		if (LoginResponseTypeEnum.JSON.equals("JSON")) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(exception.getMessage()));
		}else{
			//TODO:这里先设置一个默认的登陆失败页面，后期需要修改登陆方法 以json的方式返回给登陆调用方
			super.setDefaultFailureUrl("/login/error"); // 登录失败，跳转到登录界面
			super.onAuthenticationFailure(request, response, exception);
		}
	}
}
