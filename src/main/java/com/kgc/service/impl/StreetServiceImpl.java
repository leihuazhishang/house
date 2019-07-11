package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.DistrictExample;
import com.kgc.entity.Street;
import com.kgc.entity.StreetExample;
import com.kgc.mapper.StreetMapper;
import com.kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public int deleteByPrimaryKey(Integer id){

        int i = streetMapper.deleteByPrimaryKey(id);
        return i;
    }
    @Override
   public int deleteMore(Integer[] ids){
        int i = streetMapper.deleteMore(ids);
        return i;
   }

    public  int deleteStreet(Integer districtId){
        int i = streetMapper.deleteStreet(districtId);

        return i;
    }

    @Override
    public int insert(Street street) {
        int insert = streetMapper.insert(street);

        return insert;
    }

    @Override
    public List<Street> selectByDistrictId(Integer id) {
        List<Street> streets = streetMapper.selectByDistrictId(id);

        return streets;
    }


    @Override
    public int insertSelective(Street street) {
        return 0;
    }

    @Override
    public PageInfo<Street> selectByExample(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        //创建DistrictExample对象

        StreetExample streetExample = new StreetExample();
        // 条件查询2.获得criteria对象添加条件
                   //DistrictExample.Criteria criteria=example.createCriteria();
                   //criteria.andNameLike("%东%");
        List<Street> streets = streetMapper.selectByExample(streetExample);
       PageInfo<Street>pageInfo=new PageInfo<>(streets);
        return pageInfo;
    }



    @Override
    public Street selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public PageInfo<Street> selectByDistrictId(Integer page,Integer rows, Integer districtId) {
        PageHelper.startPage(page,rows);
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(districtId);
        List<Street> streets = streetMapper.selectByExample(streetExample);

        PageInfo<Street> pageInfo=new PageInfo<>(streets);
        return pageInfo;
    }

    @Override
    public int updateByPrimaryKeySelective(Street street) {
        int update = streetMapper.updateByPrimaryKeySelective(street);
        return update;
    }

    @Override
    public int updateByPrimaryKey(Street street) {
        return 0;
    }

    @Override
    public List<Street> selectAll() {
        List<Street> streets = streetMapper.selectAll();
        return streets;
    }


}
