package com.kgc.mapper;

import com.kgc.entity.House;
import com.kgc.entity.HouseCondition;
import com.kgc.entity.HouseExample;
import com.kgc.entity.HouseExc;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);
 List<HouseExc> selectAllHouseExcByUserId(Integer userId);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    List<HouseExc>selectByCondition(HouseCondition houseCondition);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    HouseExc selectByHouseId(String id);
    List<HouseExc>selectByIsPass(Integer ispass);


}