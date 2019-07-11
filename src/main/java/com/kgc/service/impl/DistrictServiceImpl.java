package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.entity.DistrictExample;
import com.kgc.mapper.DistrictMapper;
import com.kgc.mapper.StreetMapper;
import com.kgc.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;


    @Override
    public List<District> selectAllDistrict() {
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = districtMapper.selectByExample(districtExample);
        return districts;
    }

    @Override
    @Transactional//删除单条区域数据同时删除相对应的街道
    public int deleteByPrimaryKey(Integer id) {

        try {
            streetMapper.deleteStreet(id);
            districtMapper.deleteByPrimaryKey(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }


    @Override
   public  int deleteMore(List<Integer> list){
      try {
          districtMapper.deleteMore(list);

         streetMapper.deleteMoreStreet(list);
       return 1;}catch (Exception e){

          return 0;
      } }

    @Override
    public int insert(District district) {
        int insert = districtMapper.insert(district);

        return insert;
    }

    @Override
    public int insertSelective(District district) {
        return 0;
    }

    @Override
    public List<District> selectByExample(DistrictExample example) {
        return null;
    }

    @Override//查询所有
    public PageInfo<District> selectAll(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<District> districts = districtMapper.selectAll();
        PageInfo<District>pageInfo=new PageInfo<>(districts);
        return pageInfo;
    }

    @Override
    public District selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(District district) {

        int update = districtMapper.updateByPrimaryKeySelective(district);

        return update;
    }

    @Override
    public int updateByPrimaryKey(District record) {
        return 0;
    }


}
