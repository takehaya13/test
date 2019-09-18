package com.etc.dao;

import com.etc.entity.House;
import com.etc.vo.HouseSearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface HouseDAO {
    void fabu(House house);

    List<House> search(HouseSearchVO houseSearchVO);

    List<House> guanli(int userid);

    void delect(int hid);

    House select(int hid);

    void update(House house);

    House selectById(int Hid);
}
