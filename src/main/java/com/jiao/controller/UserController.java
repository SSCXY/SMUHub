package com.jiao.controller;

import com.github.pagehelper.PageInfo;
import com.jiao.dao.UserDao;
import com.jiao.model.Role;
import com.jiao.model.User;
import com.jiao.service.RoleService;
import com.jiao.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/adduser")
    public String addUser(User user, Integer[] roleIds){
        System.out.println("来了");
        System.out.println(user);
        System.out.println(Arrays.toString(roleIds));
        userService.addUser(user, roleIds);
        return "redirect:user";
    }
//    这个update是编辑按钮的地址
    @ResponseBody
    @GetMapping(value = "/update", produces = "text/html;charset=UTF-8")
    public String updateUser(Integer id, HttpServletRequest request){
        User user = userService.selectRelUserByUid(id);
        List<Role> allroles = roleService.selectAll();
        List<Role> roles = user.getRoles();
        String optstr = "";
        for (Role role:allroles){
            if (roles.contains(role)) {
                optstr = optstr + "<option selected value=\""+role.getId()+"\">"+role.getName()+"</option>\r\n";
            }
            else optstr = optstr + "<option value=\""+role.getId()+"\">"+role.getName()+"</option>\r\n";
        }

        String path = request.getContextPath();

        return "                <div class=\"modal-header\">\n" +
                "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" ><span aria-hidden=\"true\"></span></button>\n" +
                "                    <h4 class=\"modal-title\" id=\"updateModalLabel\">修改用户</h4>\n" +
                "                </div>\n" +
                "                <div class=\"modal-body\">\n" +
                "                    <form id=\"updateUserForm\" action=\""+path+"/updateUser\" method=\"post\" >\n" +
                "                        <input type='hidden' name='id' value='"+user.getId()+"' />"+
                "                        <div class=\"form-group\">\n" +
                "                            <label>用户名：</label>\n" +
                "                            <input type=\"text\" disabled class=\"form-control\" name=\"username\" value=\""+user.getUsername()+"\">\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >密  码(默认不修改)：</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"password\">\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >手机号：</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"phone\" value=\""+user.getPhone()+"\">\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >角  色：</label>\n" +
                "                            <select class=\"selectpicker form-control\" name=\"roleIds\" multiple>\n" +
                                                optstr +
                "                            </select>\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >邮箱：</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"email\" value=\""+user.getEmail()+"\">\n" +
                "                        </div>\n" +

                        "                <div class=\"modal-footer\">\n" +
                "                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\n" +
                "                    <button onclick=\"updateUserFormSubmit();\" type=\"submit\" class=\"btn btn-primary\">编辑用户</button>\n" +
                "                </div>"+
                "                    </form>\n" +
                "                </div>\n" +
                "\n" ;
    }
    @PostMapping(value = "updateUser")
    public String updateUser(User user, Integer[] roleIds){
        userService.updateUser(user, roleIds);
        return "redirect:/user";
    }
    @GetMapping(value = "/deleteUser")
    public String deleteUser(Integer id){
        userService.deleteByUidRelRole(id);
        return "redirect:user";
    }

    @ResponseBody
    @PostMapping(value = "/batchDelUser")
    public String batchDelUser(String uid){
        uid = uid.substring(1,uid.length() - 1);
        uid = uid.replaceAll("\"","");
        String[] uidStrArr = uid.split(",");

        Integer[] uidArr = new Integer[uidStrArr.length];
        for(int i = 0; i < uidStrArr.length; i++){
            uidArr[i] = Integer.parseInt(uidStrArr[i]);
        }
        userService.batchDelUserBuIds(uidArr);
        return "success";
    }


    @PostMapping(value = "/userSearch")
    public String searchUser(Model model, String userInfo){
        List<Role> roles = roleService.selectAll();
        model.addAttribute("allRoles",roles);
        int pageNum = 1, pageSize = 5;
        PageInfo<User> users = userService.selectUserBySearchPage(pageNum, pageSize, userInfo);


        model.addAttribute("userDatasByPager", users);

        return "user";
    }
}
