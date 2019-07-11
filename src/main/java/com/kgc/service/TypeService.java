package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.entity.DistrictExample;
import com.kgc.entity.TypeExample;

import java.util.List;

public interface TypeService {
    int deleteByPrimaryKey(Integer id);
    int deleteMore(Integer[]ids);

    int insert(Type type);

    int insertSelective(Type type);

    List<Type> selectByExample();
    PageInfo<Type>selectAll(Integer page, Integer rows);
List<Type>selectAllType();
    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type type);

    int updateByPrimaryKey(Type type);


}
