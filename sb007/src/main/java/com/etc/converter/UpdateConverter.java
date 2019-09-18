package com.etc.converter;

import com.etc.entity.House;
import com.etc.vo.UpdateVO;

public class UpdateConverter {
    public static House conver(UpdateVO updateVO) {
        House house = new House();
        house.setHId(updateVO.getHid());
        house.setHName(updateVO.getTitle2());
        house.setHRect(updateVO.getFloorage2());
        house.setHDate(updateVO.getHouseDate2());
        house.setHLoc1(updateVO.getDistrictId2());
        house.setHLoc2(updateVO.getStreetId2());
        return house;
    }
}
