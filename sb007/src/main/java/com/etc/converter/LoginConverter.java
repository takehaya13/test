package com.etc.converter;

import com.etc.entity.User;
import com.etc.vo.LoginVO;

public class LoginConverter {
    public static User convert(LoginVO loginVO){
        User user = new User();
        user.setUserName(loginVO.getName());
        user.setUserPass(loginVO.getPassword());
        return user;
    }
}
