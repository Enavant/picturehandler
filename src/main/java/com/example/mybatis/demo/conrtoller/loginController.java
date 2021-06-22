package com.example.mybatis.demo.conrtoller;

import com.example.mybatis.demo.mapper.userMapper;
import com.example.mybatis.demo.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @Autowired
    private com.example.mybatis.demo.mapper.userMapper userMapper;
    @Autowired
    HttpSession Session;
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String userLogin(String phone,String password){
        user res = userMapper.userLogin(phone,password);
        System.out.println("phone");
        if(res!=null){
            Session.setAttribute("loginUser",phone);
            return "home";

        }
        return "login";
    }
    @RequestMapping(path = "/registeruser",method = RequestMethod.POST)
    public String userRegister(String username,String phone,String password){
        user users = new user();
        users.setPhone(phone);
        users.setUsername(username);
        users.setPassword(password);
        System.out.println(users);
        userMapper.addUser(users);
        return "login";
    }
}
