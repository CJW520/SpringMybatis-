package com.cjw.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.cjw.datasource.DataSourceContextHolder;
import com.cjw.datasource.DataSourceEntity;
import com.cjw.datasource.DynamicDataSource;
import com.cjw.model.User;
import com.cjw.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource;
import static com.cjw.datasource.DataSourceContextHolder.getDataSource;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private IUserService userservice;

    @Autowired
    private DynamicDataSource dynamicDataSource;

    @RequestMapping("/get")
    public String getAllUser() {
        List<User> user = userservice.getUserAll();
        return user.toString();
    }

    public DataSource getDataSource(String id) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        // 设置数据库连接相关属性
        //正常情况下是根据id查询对应数据库的配置，然后设置到dataSource中，这里数据库没有配置，就用代码写固定的
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.10.100:3306/news?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }



    @RequestMapping("/get1")
    public String getUsers() {
        List<User> user = userservice.getUserList();
        System.out.println("USER1:" + user.toString());
        List<User> user1 = userservice.getUserList1();
        System.out.println("USER2:" + user1.toString());
        List<User> user2 = userservice.getUserList2();
        System.out.println("USER3:" + user2.toString());
        dynamicDataSource.setDataSours("db3", getDataSource(""));
        List<User> user3 = userservice.getUserList2();
        System.out.println("USER4:" + user3.toString());
        System.out.println("所有数据");
        System.out.println(user.toString());
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
        return user.toString() + "<br/>" + user1.toString() + "<br/>" + user2.toString() + "<br/>" + user3.toString();
    }


    @RequestMapping("/getid")
    public String getid(Integer id) {
        if (id == null) {
            return "请输入用户id";
        }
        User user = userservice.getUserbyid(id);
        if (user != null) {
            return user.toString();
        }
        return "没有找到任何数据！！！！！！！！！";

    }

//    @RequestMapping("/html")
//    public String html(){
//        return "index.html";
//    }
}
