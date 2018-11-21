package com.xinrui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZuulProxy //启用 zuul 自带熔断和eureka
public class ApiGateWayApp
{
    public static void main( String[] args ){
        SpringApplication.run(ApiGateWayApp.class,args);
    }
}
