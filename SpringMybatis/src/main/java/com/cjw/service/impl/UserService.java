package com.cjw.service.impl;

import com.cjw.dao.UserMapper;
import com.cjw.datasource.DS;
import com.cjw.model.User;
import com.cjw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getUserList() {
        return userMapper.userlist();
    }

    @Override
    @DS("db2")
    public List<User> getUserList1() {
        return userMapper.userlist();
    }
    @Override
    @DS("db3")
    public List<User> getUserList2() {
        return userMapper.userlist();
    }
    @Override
    @DS("db4")
    public List<User> getUserList3() {
        return userMapper.userlist();
    }

    @Override
    public List<User> getUserAll() {
        return userMapper.userlist();
    }

    @Override
    public User getUserbyid(Integer id) {
        return userMapper.getUserbyid(id);
    }

}
