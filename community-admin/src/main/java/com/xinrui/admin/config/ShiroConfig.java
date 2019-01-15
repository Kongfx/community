package com.xinrui.admin.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

	/**
	 * ShiroFilterFactoryBean 处理拦截资源文件问题。
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager Filter Chain定义说明
	 * 1、一个URL可以配置多个Filter，使用逗号分隔
	 * 2、当设置多个过滤器时，全部验证通过，才视为通过
	 * 3、部分过滤器可指定参数，如perms，roles
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//验证码过滤器
//		Map<String, Filter> filtersMap = shiroFilterFactoryBean.getFilters();
//		KaptchaFilter kaptchaFilter = new KaptchaFilter();
//		filtersMap.put("kaptchaFilter", kaptchaFilter);
		//实现自己规则roles,这是为了实现or的效果
		//RoleFilter roleFilter = new RoleFilter();
		//filtersMap.put("roles", roleFilter);
//		shiroFilterFactoryBean.setFilters(filtersMap);
		// 拦截器
		//rest：比如/admins/user/**=rest[user],根据请求的方法，相当于/admins/user/**=perms[user：method] ,其中method为post，get，delete等。
		//port：比如/admins/user/**=port[8081],当请求的url的端口不是8081是跳转到schemal：//serverName：8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。
		//perms：比如/admins/user/**=perms[user：add：*],perms参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，比如/admins/user/**=perms["user：add：*,user：modify：*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
		//roles：比如/admins/user/**=roles[admin],参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，比如/admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。//要实现or的效果看http://zgzty.blog.163.com/blog/static/83831226201302983358670/
		//anon：比如/admins/**=anon 没有参数，表示可以匿名使用。
		//authc：比如/admins/user/**=authc表示需要认证才能使用，没有参数
		//authcBasic：比如/admins/user/**=authcBasic没有参数表示httpBasic认证
		//ssl：比如/admins/user/**=ssl没有参数，表示安全的url请求，协议为https
		//user：比如/admins/user/**=user没有参数表示必须存在用户，当登入操作时不做检查
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		//配置记住我或认证通过可以访问的地址
		filterChainDefinitionMap.put("/index", "user");
		filterChainDefinitionMap.put("/", "user");
		filterChainDefinitionMap.put("/login", "kaptchaFilter");
		// <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//这段是配合 actuator框架使用的，配置相应的角色才能访问
		// filterChainDefinitionMap.put("/health", "roles[aix]");//服务器健康状况页面
		// filterChainDefinitionMap.put("/info", "roles[aix]");//服务器信息页面
		// filterChainDefinitionMap.put("/env", "roles[aix]");//应用程序的环境变量
		// filterChainDefinitionMap.put("/metrics", "roles[aix]");
		// filterChainDefinitionMap.put("/configprops", "roles[aix]");
		//开放的静态资源
		filterChainDefinitionMap.put("/favicon.ico", "anon");//网站图标
		filterChainDefinitionMap.put("/static/**", "anon");//配置static文件下资源能被访问的，这是个例子
		filterChainDefinitionMap.put("/kaptcha.jpg", "anon");//图片验证码(kaptcha框架)

		filterChainDefinitionMap.put("/api/v1/**", "anon");//API接口

		// swagger接口文档
		filterChainDefinitionMap.put("/v2/api-docs", "anon");
		filterChainDefinitionMap.put("/webjars/**", "anon");
		filterChainDefinitionMap.put("/swagger-resources/**", "anon");
		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
		filterChainDefinitionMap.put("/doc.html", "anon");

		// 其他的
		filterChainDefinitionMap.put("/**", "authc");

		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 未授权界面，不生效(详情原因看MyExceptionResolver)
		shiroFilterFactoryBean.setUnauthorizedUrl("/errorView/403_error.html");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}



}
