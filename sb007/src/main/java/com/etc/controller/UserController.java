package com.etc.controller;

import com.etc.converter.LoginConverter;
import com.etc.converter.UserConverter;
import com.etc.entity.User;
import com.etc.service.UserService;
import com.etc.vo.LoginVO;
import com.etc.vo.ResultVO;
import com.etc.vo.UserVO;
import com.etc.vo.ValidVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/valid")
    @ResponseBody
    public ResultVO valid(@RequestBody ValidVO validVO, Model model) {
        String name = validVO.getName();
        System.out.println(name);
        if (name == null || "".equals(name) ||"admin".equals(validVO.getName())){
            String regerror = "用户名不能为空";
            model.addAttribute("regerror",regerror);

            return new ResultVO(false);

        }else{

            String id = userService.weiyi(name);
        /*if ("admin".equals(validVO.getName())) {
            return new ResultVO(false);
        }*/
            if (id == null || "".equals(id)){
                System.out.println("****");
                return new ResultVO(true);
            }else {
                System.out.println(id);
                return new ResultVO(false);
            }
        }

    }

    @RequestMapping("/reg")
    public String reg(){
        return "regs";
    }

    @RequestMapping("/doreg")
    public String doreg(@Valid UserVO userVO, BindingResult bindingResult){
        System.out.println(userVO);
        if(bindingResult.hasErrors()){
            return "regs";
        }
        User user = UserConverter.convert(userVO);
        userService.reg(user);
        return "redirect:/user/login";

    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/dologin")
    public String doLogin(@Valid LoginVO loginVO, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "login";
        }
        User user = LoginConverter.convert(loginVO);
        User userAll = userService.login(user);
        System.out.println(userAll);
        if(userAll.getUserName() != null){
            model.addAttribute("user",userAll);
            return "redirect:/house/guanli";
        }

        return "login";
    }
}
