package com.jiao.controller;

import com.jiao.model.Resource;
import com.jiao.model.Role;
import com.jiao.model.User;
import com.jiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginMethod(String userInfo, String password, HttpSession session){
        User user = userService.login(userInfo, password);
        boolean ismanager = false;
        boolean ismember = false;
        List<Resource> loginUserRes = null;
        List<String> loginUserPath  = new ArrayList<>();
        if (user != null){
            session.setAttribute("loginUser", user);
            List<Role> loginUserRoles = user.getRoles();
            for (Role role:loginUserRoles) {
//              如果是超级管理员就直接停止循环
                if("manager".equals(role.getCode())){
                    ismanager = true;
                    break;
                }
                loginUserRes = role.getResources();

                for (Resource res:loginUserRes) {
                    loginUserPath.add(res.getPath());//loginUserPath存放了当前用户所拥有的所有权限
                }
            }
//          循环结束以后把当前用户的所有权限存放在session里
            session.setAttribute("ismanager", ismanager);
            session.setAttribute("loginUserAllPath", loginUserPath);
        }

        return "redirect:admin";
    }
}
