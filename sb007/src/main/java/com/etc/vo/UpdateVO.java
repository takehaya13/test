package com.etc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVO {
    private Integer hid;
    private String title2;
    private Double floorage2;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date houseDate2;
    private String districtId2;
    private String streetId2;



}
