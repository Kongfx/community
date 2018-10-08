package com.xinrui;

import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.plugins.Page;
import com.xinrui.springcloud.entity.User;
import com.xinrui.springcloud.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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
        Page<User> page = iUserService.selectPage(new Page<User>(0,10));
        System.out.println(page.getRecords());
    }

}
