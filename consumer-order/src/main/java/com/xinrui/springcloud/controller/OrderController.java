package com.xinrui.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.xinrui.springcloud.pojo.OrderUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.url}")
    private String url;
//    private String url = "http://localhost:7900/user/";

    @GetMapping("/order/{id}")
    public OrderUser getOrderUser(@PathVariable Long id){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER",false);
        String homePageUrl = instance.getHomePageUrl();
        OrderUser user = restTemplate.getForObject(homePageUrl+"/user/"+id,OrderUser.class);
        return user;
    }

}
