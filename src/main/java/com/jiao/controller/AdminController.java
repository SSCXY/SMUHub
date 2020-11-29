package com.jiao.controller;

import com.github.pagehelper.PageInfo;
import com.jiao.model.Role;
import com.jiao.model.User;
import com.jiao.service.RoleService;
import com.jiao.service.UserService;
import com.jiao.web.AuthClass;
import com.jiao.web.AuthMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@AuthClass //需要权限才能访问
@Controller
public class AdminController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @AuthMethod
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(HttpSession session){
        boolean ismanager = false;
        if (session.getAttribute("ismanager") == null){
            return "forward:index.jsp";
        }else {
            ismanager = (Boolean)session.getAttribute("ismanager");
        }

        if (ismanager == false){
            return "forward:index.jsp";

        }else {
            System.out.println("----------------------------------------"+ismanager);
            return "admin";
        }

    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
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

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String roleManage(){
        return "role";
    }

    
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public String permissonManage(){
        return "permission";
    }
}
