package com.jiao.controller;

import com.jiao.dao.UserDao;
import com.jiao.model.User;
import com.jiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        userService.addUser(user, roleIds);
        return "redirect:user";
    }
    @ResponseBody
    @GetMapping(value = "/updateUser", produces = "text/html;charset=UTF-8")
    public String updateUser(Integer id){
        User user = userService.selectRelUserByUid(id);
        return "                <div class=\"modal-header\">\n" +
                "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" ><span aria-hidden=\"true\"></span></button>\n" +
                "                    <h4 class=\"modal-title\" id=\"updateModalLabel\">修改用户</h4>\n" +
                "                </div>\n" +
                "                <div class=\"modal-body\">\n" +
                "                    <form action=\"#\" >\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label>用户名：</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"username\" value=\""+user.getUsername()+"\">\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >密  码：</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"password\">\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >手机号：</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"phone\" value=\""+user.getPhone()+"\">\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >角  色：</label>\n" +
                "                            <select class=\"selectpicker form-control\" name=\"roleIds\" multiple>\n" +
                "                                <c:forEach items=\"${allRoles}\" var=\"role\">\n" +
                "                                    <option value=\"${role.id}\">${role.rname}</option>\n" +
                "                                </c:forEach>\n" +
                "                            </select>\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label >邮箱：</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"email\" value=\""+user.getEmail()+"\">\n" +
                "                        </div>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"modal-footer\">\n" +
                "                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\n" +
                "                    <button type=\"button\" class=\"btn btn-primary\">编辑用户</button>\n" +
                "                </div>";
    }

}
