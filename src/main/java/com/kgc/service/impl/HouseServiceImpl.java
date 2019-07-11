package com.kgc.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.entity.HouseCondition;
import com.kgc.entity.HouseExample;
import com.kgc.entity.HouseExc;
import com.kgc.mapper.HouseMapper;
import com.kgc.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(House house) {
        return 0;
    }

    @Override//添加房屋信息
    public int insertSelective(House house) {
        int i = houseMapper.insertSelective(house);
        return i;
    }



    @Override
    public List<House> selectByExample(HouseExample example) {
        return null;
    }

    @Override
    public House selectByPrimaryKey(String id) {
        House house = houseMapper.selectByPrimaryKey(id);

        return house;
    }

    @Override
    public int updateByPrimaryKeySelective(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int updateByPrimaryKey(House house) {
        return 0;
    }

    @Override
    public PageInfo<HouseExc> selectByCondition(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        List<HouseExc> houseExcs = houseMapper.selectByCondition(houseCondition);
        PageInfo<HouseExc>pageInfo=new PageInfo<>(houseExcs);
        return pageInfo;
    }


    @Override
    public PageInfo<HouseExc> selectAllHouseExcByUserId(Integer page,Integer rows, Integer userId) {
        PageHelper.startPage(page,rows);
        List<HouseExc> houseExcs = houseMapper.selectAllHouseExcByUserId(userId);

        PageInfo<HouseExc>pageInfo=new PageInfo<>(houseExcs);

        return pageInfo;
    }
    @Override
    public HouseExc selectByHouseId(String id){
        HouseExc houseExc = houseMapper.selectByHouseId(id);

        return houseExc;


    }
    @Override
    public PageInfo<HouseExc> selectIsPass(Integer page,Integer rows  ,Integer ispass) {

        PageHelper.startPage(page,rows);
        List<HouseExc> houseExcs = houseMapper.selectByIsPass(ispass);
        PageInfo<HouseExc> pageInfo=new PageInfo<>(houseExcs);
        return pageInfo;
    }
    @Override
    public int deleteByIsdel(String id) {
        House house = new House();
        house.setId(id);
        house.setIsdel(1);
        //调用DAO修改方法
        int i = houseMapper.updateByPrimaryKeySelective(house);
        return i;
    }


}
