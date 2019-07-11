package com.kgc.mapper;

import com.kgc.entity.Type;
import com.kgc.entity.TypeExample;
import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteMore(Integer[]ids);
    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
  List<Type>  selectAll();
}