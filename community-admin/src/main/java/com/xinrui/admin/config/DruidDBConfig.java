package com.xinrui.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DruidDBConfig {

	 @Value("${spring.datasource.url}") 
	  private String dbUrl; 
	    
	  @Value("${spring.datasource.username}") 
	  private String username; 
	    
	  @Value("${spring.datasource.password}") 
	  private String password; 
	    
	  @Value("${spring.datasource.driver-class-name}") 
	  private String driverClassName; 

	  @Bean   //声明其为Bean实例 
	  @Primary //在同样的DataSource中，首先使用被标注的DataSource 
	  public DataSource dataSource(){ 
	    DruidDataSource datasource = new DruidDataSource(); 
	    datasource.setUrl(this.dbUrl);
	    datasource.setUsername(username); 
	    datasource.setPassword(password); 
	    datasource.setDriverClassName(driverClassName); 
	    return datasource;
	  } 
}
