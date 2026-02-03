package com.john.usercenterbejohn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.john.usercenterbejohn.model.User;


/**
* @author duqingyang
* @description 针对表【user】的数据库操作Service
* @createDate 2026-01-20 12:03:31
*/
public interface UserService extends IService<User> {
    Long userRegister(String account, String password, String checkPassword);

}
