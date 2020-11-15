package com.jiao.controller;

import com.jiao.model.Role;
import com.jiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/admin")
    public String admin(){
        System.out.println("1111111111111111111111111111111111111111");
        return "admin";
    }

    @GetMapping(value = "/user")
    public String userManage(Model model){
//        查询角色信息回显到前端select框中
        List<Role> roles = roleService.selectAll();
        model.addAttribute("allRoles",roles);
        return "user";
    }

    @GetMapping(value = "/role")
    public String roleManage(){
        return "role";
    }

    @GetMapping(value = "/permission")
    public String permissonManage(){
        return "permission";
    }
}
