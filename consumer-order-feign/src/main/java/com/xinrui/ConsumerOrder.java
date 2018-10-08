package com.xinrui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义RibbonConfig 不能被主程序加载 需要通过ComponentScan进行排除
 * 或者将 RibbonConfig 放到 主程序上一级目录
 * 或者采用配置文件的方式进行配置
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "PROVIDER-USER1")
public class ConsumerOrder
{
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerOrder.class,args);
    }
}
