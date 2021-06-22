package com.example.mybatis.demo.conrtoller;

import com.example.mybatis.demo.mapper.userMapper;
import com.example.mybatis.demo.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController

public class userController {

    @Autowired
    private userMapper userMapper;
    @Autowired
    HttpSession Session;

    @CrossOrigin
    @GetMapping("/queryUserList")
    public List<user> querylist(){
        List<user> userList = userMapper.queryUserList();
        return userList;
    }
    @GetMapping("/queryById/{id}")
    public user queryById(@PathVariable("id") Integer id){
        user users = userMapper.queryUserById(id);
        return users;
    }
    @GetMapping("/updataUser")
    public int updataUser(user user){
        userMapper.updataUser(user);
        return 1;
    }
    @GetMapping("/deleteUser/{id}")
    public int deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
        return 1;
    }



}
