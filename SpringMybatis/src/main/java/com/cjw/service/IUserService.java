package com.cjw.service;

import com.cjw.model.User;

import java.util.List;

public interface IUserService  {
    List<User> getUserAll();
    List<User> getUserList();
    List<User> getUserList1();
    List<User> getUserList2();
    List<User> getUserList3();
    User getUserbyid(Integer id);
}

