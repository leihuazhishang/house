package com.kgc.controller;


import com.github.pagehelper.PageInfo;
import com.kgc.entity.UserCondition;
import com.kgc.entity.Users;
import com.kgc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController//@controller和@responseBody的结合
@RequestMapping("/users/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("selectAll")
    public Map<String,Object>selectAll(UserCondition userCondition){

        PageInfo<Users> pageInfo = usersService.selectByExample(userCondition);

        Map<String,Object>map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    @RequestMapping("deleteByPrimaryKey")
    public String deleteByPrimaryKey(Integer id){

        int i = usersService.deleteByPrimaryKey(id);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("deleteMore")
    public String deleteMore(Integer[] ids){
        int i = usersService.deleteMore(ids);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("updateByPrimaryKeySelective")
    public String updateByPrimaryKeySelective(Users user){
        System.out.println(user);
        int  i= usersService.updateByPrimaryKeySelective(user);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("insert")
    public String insert(Users user){
        int i = usersService.insert(user);
        return "{\"result\":"+i+"}";
    }


}
