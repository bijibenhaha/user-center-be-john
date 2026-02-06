package com.john.usercenterbejohn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.john.usercenterbejohn.model.User;

import javax.servlet.http.HttpServletRequest;


/**
* @author duqingyang
* @description 针对表【user】的数据库操作Service
* @createDate 2026-01-20 12:03:31
*/
public interface UserService extends IService<User> {
    /**
     * 注册
     * @param account
     * @param password
     * @param checkPassword
     * @return
     */
    Long userRegister(String account, String password, String checkPassword);

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    User userLogin(String account, String password, HttpServletRequest request);


}
