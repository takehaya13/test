package com.etc.dao;

import com.etc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDAO {
    void reg(User user);

    User login(User user);

    String weiyi(String userName);


}
