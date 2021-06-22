package com.example.mybatis.demo.conrtoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
