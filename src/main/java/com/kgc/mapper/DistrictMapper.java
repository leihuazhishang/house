package com.kgc.mapper;

import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteMore(List<Integer> list);
    int insert(District district);

    int insertSelective(District district);

    List<District> selectByExample(DistrictExample example);
    List<District>selectAll();


    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District district);

    int updateByPrimaryKey(District district);
}