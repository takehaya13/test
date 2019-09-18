package com.etc.service;

import com.etc.dao.UserDAO;
import com.etc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserDAO userDAO;

    public void reg(User user){
        userDAO.reg(user);
    }

    public User login(User user){
        return userDAO.login(user);
    }

    public String weiyi(String userName){
        return userDAO.weiyi(userName);
    }
}
