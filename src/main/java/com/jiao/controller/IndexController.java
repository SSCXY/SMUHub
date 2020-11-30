package com.jiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//太友好了-_-
@Controller
public class IndexController {
    @GetMapping(value = {"/index.html", "/", "index", "/index.jsp"})
    public String index(){
        return "forward:index.jsp";
    }

}
