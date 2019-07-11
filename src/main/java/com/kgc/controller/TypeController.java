package com.kgc.controller;


import com.github.pagehelper.PageInfo;
import com.kgc.entity.Type;
import com.kgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type/")
public class TypeController {
    @Autowired
    private TypeService typeService;
    //查询所有
    @RequestMapping("selectAll")
    public Map<String,Object>selectAll(Integer page,Integer rows){

        PageInfo<Type> PageInfo = typeService.selectAll(page, rows);
        Map<String,Object>map=new HashMap<>();
        map.put("total",PageInfo.getTotal());
        map.put("rows",PageInfo.getList());
        return map;
    }
    //修改
    @RequestMapping("updateByPrimaryKeySelective")
    public String updateByPrimaryKeySelective(Type type){
        int i = typeService.updateByPrimaryKeySelective(type);

        return "{\"result\":"+i+"}";
    }
    //删除多条
    @RequestMapping("deleteMore")
    public String deleteMore(Integer[]ids){

        int i = typeService.deleteMore(ids);
        return "{\"result\":"+i+"}";
    }
    //删除
       @RequestMapping("deleteByPrimaryKey")
    public String deleteByPrimaryKey(Integer id){
           int i = typeService.deleteByPrimaryKey(id);
           return "{\"result\":"+i+"}";
       }

       @RequestMapping("insert")
       public String insert(Type type){
           int insert = typeService.insert(type);
            return "{\"result\":"+insert+"}";

       }

}
