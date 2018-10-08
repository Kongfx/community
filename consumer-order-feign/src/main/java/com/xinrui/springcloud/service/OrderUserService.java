package com.xinrui.springcloud.service;

import com.xinrui.springcloud.pojo.OrderUser;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("PROVIDER-USER1")
public interface OrderUserService {
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
//    @RequestLine("GET /user/{id}")
    OrderUser getOrderUserById(@PathVariable("id") Long id);

    /*
     *  复杂对象若使用Feign 则只能使用POST 否则报错 405 请求方式不正确
     */
    @RequestMapping(value = "/get-user",method = RequestMethod.POST)
//    @RequestLine("POST /get-user")
    OrderUser getUser(OrderUser user);

}
