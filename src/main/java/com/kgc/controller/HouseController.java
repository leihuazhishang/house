package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.House;
import com.kgc.entity.HouseExc;
import com.kgc.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pass/")
public class HouseController {
    @Autowired
    private HouseService houseService;


    @RequestMapping("selectYesPass")
    @ResponseBody
    public Map<String, Object> selectYesPass(Integer page, Integer rows) {
        System.out.println("yes");
        PageInfo<HouseExc> pageInfo = houseService.selectIsPass(page=page==null?1:page, rows=rows==null?4:rows, 1);
        Map<String, Object> map = new HashMap<>();
        System.out.println(pageInfo.getList().size());
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @RequestMapping("selectNoPass")
    @ResponseBody
    public Map<String, Object> selectNoPass(Integer page, Integer rows) {
        System.out.println("no");
        PageInfo<HouseExc> pageInfo = houseService.selectIsPass(page=page==null?1:page, rows=rows==null?4:rows, 0);
        Map<String, Object> map = new HashMap<>();
        System.out.println(pageInfo.getList().size());
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @RequestMapping("ispass")
    @ResponseBody
    public String ispass(String id){
        House house = new House();
        house.setId(id);
        house.setIspass(1);

        int i = houseService.updateByPrimaryKeySelective(house);

       return "{\"result\":"+i+"}";

    }
    //逻辑删除
    @RequestMapping("deleteByIsdel")
    @ResponseBody
    public String deleteByIsdel(String id){

        int i = houseService.deleteByIsdel(id);
        return "{\"result\":"+i+"}";
    }

//根据房屋编号查询房屋信息

    @RequestMapping("selectByPrimaryKey")
    public String selectByPrimaryKey(String id, Model model){

        HouseExc houseExc = houseService.selectByHouseId(id);

        model.addAttribute("houseExc",houseExc);
        return "page/details";

    }
}
