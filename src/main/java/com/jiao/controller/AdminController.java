package com.jiao.controller;

import com.github.pagehelper.PageInfo;
import com.jiao.model.Resource;
import com.jiao.model.Role;
import com.jiao.model.User;
import com.jiao.service.ResourceService;
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
    @Autowired
    private ResourceService resourceService;
    //后台主页
    @AuthMethod
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(HttpSession session){
        /*
        * 开始我想的是只要用户登录后session中的ismanager不是true就拦截，
        * 但我忽略了session为空时的判断，如果session为空也应该被拦截，
        * 但是需要跳转到首页上而非做出访问权限提示
        */

        boolean ismanager = false;
        if (session.getAttribute("ismanager") == null){
            return "forward:index.jsp";
        }else {
            ismanager = (Boolean)session.getAttribute("ismanager");
        }

        if (ismanager == false){
            return "forward:index.jsp";

        }else {
            return "admin";
        }

    }
    //用户管理页面
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userManage(Model model, Integer pageNum, Integer pageSize) throws InterruptedException {
        //查询角色信息回显到前端select框中

        List<Role> roles = roleService.selectAll();
        model.addAttribute("allRoles",roles);
        PageInfo<User> users;
        if(pageNum != null && pageSize != null){
            users = userService.selectUserByPager(pageNum, pageSize);
        }else {
        //这里需要给一个默认值，否则通过其他controller跳转时分页信息都是空的
            users = userService.selectUserByPager(1, 5);
        }

        model.addAttribute("userDatasByPager", users);
        return "user";
    }
    //角色列表页面
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String roleManage(Model model){
        List<Role> roles = roleService.selectAll();
        System.out.println(roles);
        model.addAttribute("roles", roles);
        return "role";
    }

    //权限路径
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public String permissonManage(Model model){
        List<Resource> resources = resourceService.selectAll();
        model.addAttribute("permissions", resources);
        return "permission";
    }
}
