package com.jiao.controller;

import com.jiao.model.Role;
import com.jiao.model.User;
import com.jiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;


@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){


        return "register";
    }
    @Transactional
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(String username, String password, String phone, String email){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEnable(1);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddDate(new Date());
        Integer roleIds[] = new Integer[1];
        roleIds[0] = 3;
        userService.addUser(user,roleIds);
        return "forward:index.jsp";
    }
}
