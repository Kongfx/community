package com.xinrui.springcloud.service;

import com.xinrui.springcloud.pojo.OrderUser;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PROVIDER-USER1")
public interface OrderUserService {
    @RequestLine("GET /user/{id}")
    OrderUser getOrderUserById(@PathVariable("id") Long id);

    /*
     *  复杂对象若使用Feign 则只能使用POST 否则报错 405 请求方式不正确
     */
    @RequestLine("POST /get-user")
    OrderUser getUser(OrderUser user);

}
