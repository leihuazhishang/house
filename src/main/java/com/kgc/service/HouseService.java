package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.entity.HouseCondition;
import com.kgc.entity.HouseExample;
import com.kgc.entity.HouseExc;

import java.util.List;

public interface HouseService {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    PageInfo<HouseExc>selectByCondition(HouseCondition houseCondition);

    PageInfo<HouseExc> selectAllHouseExcByUserId(Integer page,Integer rows,Integer userId);
    HouseExc selectByHouseId(String id);

    PageInfo<HouseExc> selectIsPass(Integer page,Integer rows,Integer ispass);

    int deleteByIsdel(String id);
}
