package com.etc.service;

import com.etc.dao.HouseDAO;
import com.etc.entity.House;
import com.etc.vo.HouseSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseDAO houseDAO;

    public void fabu(House house){
        houseDAO.fabu(house);
    }

    public List<House> search(HouseSearchVO houseSearchVO){
        return houseDAO.search(houseSearchVO);
    }
    public List<House> guanli(int userid){
        return houseDAO.guanli(userid);
    }

    public void delect(int hid){
        houseDAO.delect(hid);
    }

    public House select(int hid){
       return houseDAO.select(hid);
    }
    public void update(House house){
        houseDAO.update(house);
    }

    public House selectById(int Hid){
        return houseDAO.selectById(Hid);
    }
}
