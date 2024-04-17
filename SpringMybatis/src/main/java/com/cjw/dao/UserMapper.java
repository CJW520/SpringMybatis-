package com.cjw.dao;

import com.cjw.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MSI
 */
public interface UserMapper {

    List<User> userlist();

    User getUserbyid(@Param("id") Integer id);


}
