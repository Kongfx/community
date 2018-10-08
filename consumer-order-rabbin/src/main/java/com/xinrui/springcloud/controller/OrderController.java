package com.xinrui.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.xinrui.springcloud.pojo.OrderUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
/*    @Value("${user.url}")
    private String url;//配置文件 设置*/
//    private String url = "http://localhost:7900/user/";//提供者服务地址

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/order/{id}")
    public OrderUser getOrderUser(@PathVariable Long id){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER",false);
        String homePageUrl = instance.getHomePageUrl();
        OrderUser user = restTemplate.getForObject(homePageUrl+"/user/"+id,OrderUser.class);
        return user;
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance1 = loadBalancerClient.choose("PROVIDER-USER1");
        String result = "==="+serviceInstance1.getServiceId()+serviceInstance1.getHost()+":"+serviceInstance1.getPort();
        System.err.println(result);
/*        ServiceInstance serviceInstance2 = loadBalancerClient.choose("PROVIDER-USER2");
        result = "==="+serviceInstance2.getServiceId()+serviceInstance2.getHost()+":"+serviceInstance2.getPort();
        System.err.println(result);*/
        return "end";
    }
}
