package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;

import java.util.List;

public interface DistrictService {
    List<District> selectAllDistrict();
    int deleteByPrimaryKey(Integer id);
    int deleteMore(List<Integer> list);

    int insert(District district);

    int insertSelective(District district);

    List<District> selectByExample(DistrictExample example);
    PageInfo<District>selectAll(Integer page,Integer rows);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District district);

    int updateByPrimaryKey(District district);


}
