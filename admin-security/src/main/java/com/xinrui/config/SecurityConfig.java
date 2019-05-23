package com.xinrui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author kong
 * @Date 2019/4/24 13:34
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired
	protected AuthenticationFailureHandler myAuthenticationFailHander;
	@Autowired
	private DataSource dataSource;
	@Autowired
	protected UserDetailsService userDetailsService;


	@Bean
	public PasswordEncoder passwordEncoder(){
		//这个应该是自己定义的实现了PasswordEncoder 的密码加密逻辑的类
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JdbcTokenRepositoryImpl tokenRepository(){
		JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
		j.setDataSource(dataSource);
		return j;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//解决静态资源被SpringSecurity拦截的问题
		web.ignoring().antMatchers("/static/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
				.loginPage("/toLogin")
				.loginProcessingUrl("/auth/from")
				.successHandler(myAuthenticationSuccessHandler)
				.failureHandler(myAuthenticationFailHander)
				.and()
			.rememberMe()
				.tokenRepository(tokenRepository())
				.tokenValiditySeconds(60*60*24*2)
				.userDetailsService(userDetailsService)
				.and()
			.authorizeRequests()
				.antMatchers("/img/**,/templates/**","/static/**","/toLogin","/login/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.csrf().disable();
	}
}
