package com.jiao.controller;

import com.jiao.model.Uploadfile;

import com.jiao.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//太友好了-_-
@Controller
public class IndexController {
//
//    @RequestMapping(value = {"/index.html", "index", "/index.jsp"})
//    public String index(){
//
//        return "redirect:index.jsp";
//    }

//    @RequestMapping(value = {"/index.html", "/", "index", "/index.jsp"}, method = RequestMethod.POST)
//    public String index2(){
//        List<Uploadfile> uploadFiles = fileService.selectAll();
//        System.out.println("POST" + uploadFiles);
//        return "forward:index.jsp";
//    }

}
