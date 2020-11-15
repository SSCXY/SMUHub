package com.jiao.controller;

import com.jiao.dao.UserDao;
import com.jiao.model.User;
import com.jiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;


@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "/adduser")
    public String addUser(User user, Integer[] roleIds){
        System.out.println("来了");
        System.out.println(user);
        System.out.println(Arrays.toString(roleIds));
        return "redirect:user";
    }



}
