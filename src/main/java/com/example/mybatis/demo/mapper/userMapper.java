package com.example.mybatis.demo.mapper;

import com.example.mybatis.demo.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解表示mybatis接口
@Mapper
@Repository
public interface userMapper {
    List<user> queryUserList();

    user queryUserById(int id);

    int addUser(user user);

    int updataUser(user uesr);

    int deleteUser(int id);

    user userLogin(String phone,String password);

}
