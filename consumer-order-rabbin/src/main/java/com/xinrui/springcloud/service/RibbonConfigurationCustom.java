package com.xinrui.springcloud.service;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfigurationCustom {

    @Autowired
    IClientConfig iClientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}
