package com.etc.controller;

import com.etc.common.Constant;
import com.etc.converter.HouseConverter;
import com.etc.converter.UpdateConverter;
import com.etc.entity.House;
import com.etc.entity.User;
import com.etc.service.HouseService;
import com.etc.vo.HouseSearchVO;
import com.etc.vo.HouseSearchVO2;
import com.etc.vo.HouseVO;
import com.etc.vo.UpdateVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/house")
public class HouseController {
    public static final String UPLOAD_DIR = "E:\\maven\\img\\";

    @RequestMapping("/images")
    public String images(String imgName, HttpServletResponse response) throws IOException {
        //将图片的输入流复制到response的输出流
        IOUtils.copy(new FileInputStream(UPLOAD_DIR + imgName),response.getOutputStream());
        return null;
    }

    @Autowired
    private HouseService houseService;

    @RequestMapping("/fabu")
    public String fabu(HouseVO houseVO, HttpSession httpSession) throws IOException {
        System.out.println(houseVO);

        //file.getOriginalFilename()是得到上传时的文件名,spring的transferTo保存文件方法
        houseVO.getHImg().transferTo(new File(UPLOAD_DIR + houseVO.getHImg().getOriginalFilename()));
        //从session中获取
        User user = (User) httpSession.getAttribute("user");
        House house = HouseConverter.conver(houseVO,houseVO.getHImg().getOriginalFilename(),user);
        houseService.fabu(house);
        return "redirect:guanli";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("vo") HouseSearchVO2 houseSearchVO, Integer pageNum, Model model){
        if(pageNum == null){
            //第一次访问
            pageNum = 1;
        }

        System.out.println(houseSearchVO);
        HouseSearchVO houseSearchVO1 =new HouseSearchVO();
        houseSearchVO1.setName(houseSearchVO.getName());
        if(!StringUtils.isEmpty(houseSearchVO.getFloorage())){
            String[] strs = houseSearchVO.getFloorage().split("-");
            houseSearchVO1.setMinRect(Double.valueOf(strs[0]));
            houseSearchVO1.setMaxRect(Double.valueOf(strs[1]));
        }
        //System.out.println(houseSearchVO1);
        PageHelper.startPage(pageNum, Constant.PAGE_SIZE);
        PageInfo<House> pageInfo = new PageInfo<>(houseService.search(houseSearchVO1));
        model.addAttribute("pageInfo",pageInfo);
        return "list";

    }

    @RequestMapping("/guanli")
    public String guanli(Integer pageNum, Model model, HttpSession httpSession){
        if(pageNum == null){
            //第一次访问
            pageNum = 1;
        }

        User user = (User) httpSession.getAttribute("user");
        System.out.println(user);
        PageHelper.startPage(pageNum, Constant.PAGE_SIZE);
        PageInfo<House> pageInfo = new PageInfo<>(houseService.guanli(user.getUserId()));
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }

    @RequestMapping("/delect")
    public String delect(int hid){
        houseService.delect(hid);
        return "redirect:guanli";
    }

    @RequestMapping("/updateGl")
    public String updateGl(int hid , Model model){
        System.out.println(hid);
        House house = houseService.select(hid);
        model.addAttribute("thisHouse",house);
        return "update";
    }

    @RequestMapping("/doupdate")
    public String update(UpdateVO updateVO){
        System.out.println(updateVO);
        House house = UpdateConverter.conver(updateVO);
        houseService.update(house);
        return "redirect:guanli";
    }

    @RequestMapping("/details")
    public String details(String Hid, Model model){
        Integer hid = Integer.valueOf(Hid);
        System.out.println(hid);
        House hDetails = houseService.selectById(hid);
        model.addAttribute("hDetails",hDetails);
        return "details";
    }
}
