package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Users;
import com.kgc.entity.UserCondition;
import com.kgc.entity.Users;

import java.util.List;

public interface UsersService {
    int deleteByPrimaryKey(Integer id);
    int deleteUsers(Integer districtId);
    int deleteMore(Integer[] ids);

    int insert(Users users);
    int frontInsert(Users users);
    int selectByExample1(String name);

    int insertSelective(Users users);

    PageInfo<Users> selectByExample(UserCondition userCondition);



    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users users);

    int updateByPrimaryKey(Users users);

    Users selectByExample2(String userName,String password);
}
