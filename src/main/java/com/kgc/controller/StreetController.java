package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Street;
import com.kgc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import java.util.Map;

@Controller
@RequestMapping("/street")
public class StreetController {
    @Autowired
    private StreetService streetService;

@ResponseBody
@RequestMapping("/selectAll")
    public Map<String,Object> selectAll(Integer page,Integer rows){

    PageInfo<Street> pageInfo = streetService.selectByExample(page, rows);
    Map<String,Object>map=new HashMap<>();
    map.put("total",pageInfo.getTotal());
    map.put("rows",pageInfo.getList());
    return map;
}

@RequestMapping("/deleteByPrimaryKey")
@ResponseBody
    public String deleteByPrimaryKey(Integer id){

        int i = streetService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }

    @ResponseBody
    @RequestMapping("/deleteMore")
    public String deleteMore(Integer[]ids){
        int i = streetService.deleteMore(ids);

        return "{\"result\":"+i+"}";
    }
    @ResponseBody
    @RequestMapping("/updateByPrimaryKeySelective")
    public String updateByPrimaryKeySelective(Street street){

    int i = streetService.updateByPrimaryKeySelective(street);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("selectByDistrictId")
    @ResponseBody
    public Map<String,Object> selectByDistrictId(Integer page,Integer rows,Integer districtId){
     PageInfo<Street> pageInfo = streetService.selectByDistrictId(page, rows, districtId);

         Map<String,Object>map=new HashMap<>();
         map.put("total",pageInfo.getTotal());
         map.put("rows",pageInfo.getList());
        return map;
    }
    @ResponseBody
    @RequestMapping("insert")
    public String insert(Street street){

        int insert = streetService.insert(street);
        return "{\"result\":"+insert+"}";
    }
}
