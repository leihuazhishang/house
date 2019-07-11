package com.kgc.mapper;

import com.kgc.entity.Street;
import com.kgc.entity.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteMoreStreet(List<Integer>list);
    int deleteMore(Integer[]ids);
    int deleteStreet(Integer districtId);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);
    List<Street>selectAll();


    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
    List<Street> selectByDistrictId(Integer id);


}