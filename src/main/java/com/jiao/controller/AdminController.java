package com.jiao.controller;

import com.github.pagehelper.PageInfo;
import com.jiao.model.Role;
import com.jiao.model.User;
import com.jiao.service.RoleService;
import com.jiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public String admin(){

        return "admin";
    }

    @GetMapping(value = "/user")
    public String userManage(Model model, Integer pageNum, Integer pageSize) throws InterruptedException {
//        查询角色信息回显到前端select框中

        List<Role> roles = roleService.selectAll();
        model.addAttribute("allRoles",roles);
        PageInfo<User> users;
        if(pageNum != null && pageSize != null){
            users = userService.selectUserByPager(pageNum, pageSize);
        }else {
            users = userService.selectUserByPager(1, 5);
        }

        model.addAttribute("userDatasByPager", users);
        Thread.sleep(300);
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
