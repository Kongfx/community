package com.xinrui;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xinrui.springcloud.entity.User;
import com.xinrui.springcloud.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderUserTest
{
    @Resource
    private IUserService iUserService;


    @Test
    public void testUser(){
        iUserService.list(new QueryWrapper<User>().like("username","a"));

    }

}
