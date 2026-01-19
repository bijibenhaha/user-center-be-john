package com.john.usercenterbejohn;

import com.john.usercenterbejohn.demos.web.mapper.UserMapper;
import com.john.usercenterbejohn.demos.web.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
//@RunWith(SpringRunner.class)
class UserCenterBeJohnApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void testUser() {
        System.out.println("----test user select----");
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(2,userList.size());
        userList.forEach(System.out::println);

    }

}
