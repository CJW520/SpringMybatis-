package com.cjw.dao;

import com.cjw.model.PubMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface PubMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubMenu record);

    int insertSelective(PubMenu record);

    PubMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubMenu record);

    int updateByPrimaryKey(PubMenu record);
}