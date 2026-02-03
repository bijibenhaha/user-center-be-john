package com.john.usercenterbejohn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.john.usercenterbejohn.mapper.UserMapper;
import com.john.usercenterbejohn.model.User;
import com.john.usercenterbejohn.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author duqingyang
* @description 针对表【user】的数据库操作Service实现
* @createDate 2026-01-20 12:03:31
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    private static final String SALT = "john";

    /**
     * 用户注册功能
     * @param account
     * @param password
     * @param checkPassword
     * @return
     */
    public Long userRegister(String account, String password, String checkPassword){
        //● 判空
        if (StringUtils.isAnyBlank(account,password,checkPassword)){
            return -1l;
        }
        //● 账户 不小于4位
        if (account.length() < 4){
            return -1l;
        }

        //● 账户 不包含特殊字符 **
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(account);
        if (matcher.find()) {
            return -1l;
        }
        //● 账户 不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",account);
        int count = this.count(queryWrapper);
        if (count > 0){
            return -1l;
        }


        //● 密码 不小于8位
        if (password.length() < 8){
            return -1l;
        }
        //● 密码和校验密码 相同
        if (!password.equals(checkPassword)){
            return -1l;
        }

        // 对密码进行加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());

        // 插入数据库
        User user = new User();
        user.setAccount(account);
        user.setPassword(encryptPassword);
        user.setIsValid(1);
        boolean save = this.save(user);
        if (!save){
            return -1l;
        }

        return user.getId();
    }

}




