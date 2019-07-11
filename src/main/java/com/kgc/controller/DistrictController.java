package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.District;
import com.kgc.service.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;


    //查询所有
    @RequestMapping("/selectAll")
    @ResponseBody
    public Map<String,Object>selectAll(Integer page,Integer rows){
        PageInfo<District> pageInfo = districtService.selectAll(page, rows);

        Map<String,Object>map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
//添加
    @RequestMapping("/insert")
    @ResponseBody
    public  String insert(District district){
        int insert = districtService.insert(district);

        return "{\"result\":"+insert+"}";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateByPrimaryKeySelective")
    public String updateByPrimaryKeySelective(District district){

        int update = districtService.updateByPrimaryKeySelective(district);
        return "{\"result\":"+update+"}";
    }
//删除多条
    @ResponseBody
    @RequestMapping("/deleteMore")
    public String deleteByPrimaryKey(Integer[] ids){
        int i = districtService.deleteMore(Arrays.asList(ids));
        return "{\"result\":"+i+"}";
    }
//删除一条
    @ResponseBody
    @RequestMapping("/deleteByPrimaryKey")

    public String deleteByPrimaryKey(Integer id){


        int i = districtService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }
    //查询所有区域
    @RequestMapping("/selectAllDistrict")
    @ResponseBody
    public  List<District> selectAllDistrict(){
        List<District>districts = districtService.selectAllDistrict();
        for (District district : districts) {
            System.out.println(district.getId()+" "+district.getName());
        }
        return districts;
    }
}
