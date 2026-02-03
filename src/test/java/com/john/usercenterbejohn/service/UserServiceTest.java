package com.john.usercenterbejohn.service;
import java.util.Date;

import com.john.usercenterbejohn.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest  {

    @Resource
    private UserService userService;

    /**
     * 测试数据库是否可以插入数据
     */
    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("john");
        user.setAccount("0000");
        user.setPassword("1234");
        user.setAvatarUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnOcablrBbVU1v0tGtemj2Aeis5EJgDjTNhg&s");
        user.setGender(0);
        user.setPhone("8611111111111");
        user.setEmail("john@gmail.com");
        user.setUserStatus(0);
        user.setIsValid(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelete(0);
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);

    }

    /**
     * 测试用户注册功能
     */
    @Test
    public void testUserRegister(){
        String account = "123";
        String password = "123";
        String checkPassword = "";
        Long result = userService.userRegister(account, password, checkPassword);
        Assertions.assertEquals(-1l,result);
        account = "12345";
        password = "123678999";
        checkPassword = "123678999";
        result = userService.userRegister(account, password, checkPassword);
        Assertions.assertTrue(result > 0);
    }
}