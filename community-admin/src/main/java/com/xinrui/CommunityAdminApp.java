package com.xinrui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xinrui.admin.dao")
public class CommunityAdminApp
{
    public static void main( String[] args ){
        SpringApplication.run(CommunityAdminApp.class,args);
    }
}
