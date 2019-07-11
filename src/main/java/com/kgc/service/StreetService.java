package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Street;
import com.kgc.entity.StreetExample;

import java.util.List;

public interface StreetService {
    int deleteByPrimaryKey(Integer id);
    int deleteStreet(Integer districtId);
    int deleteMore(Integer[]ids);

    int insert(Street street);
    List<Street> selectByDistrictId(Integer id);

    int insertSelective(Street street);

    PageInfo<Street> selectByExample(Integer page,Integer rows);



    Street selectByPrimaryKey(Integer id);
    PageInfo<Street> selectByDistrictId(Integer page,Integer rows,Integer districtId);

    int updateByPrimaryKeySelective(Street street);

    int updateByPrimaryKey(Street street);
    List<Street>selectAll();
}
