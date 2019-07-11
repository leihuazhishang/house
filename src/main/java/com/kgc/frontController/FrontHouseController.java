package com.kgc.frontController;


import com.github.pagehelper.PageInfo;
import com.kgc.entity.*;
import com.kgc.service.DistrictService;
import com.kgc.service.HouseService;
import com.kgc.service.StreetService;
import com.kgc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/house/")
public class FrontHouseController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private StreetService streetService;
    @Autowired
    private HouseService houseService;


    //查询所有区域和所有房屋类型
    @RequestMapping("publish")
    public String publish( Model model){
        List<Type> types = typeService.selectByExample();
        List<District> districts = districtService.selectAllDistrict();

        model.addAttribute("types",types);
        model.addAttribute("districts",districts);

        return "page/fabu";
    }

    //根据区域编号查询街道
    @RequestMapping("selectAllByDistrictId")
        @ResponseBody
        public List<Street> selectAllByDistrictId(Integer id){

        List<Street> streets = streetService.selectByDistrictId(id);
        return streets;

    }
    //发布房屋信息
    @RequestMapping("insertSelective")
    public String insertSelective(House house, @RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile, HttpSession session) throws IOException {
        String ofname = pfile.getOriginalFilename();

        String su = ofname.substring(ofname.lastIndexOf("."));
        String name=System.currentTimeMillis()+su;
        File file=new File("G:\\zuoye\\"+name);
        pfile.transferTo(file);


        Users user = (Users)session.getAttribute("user");
        house.setUserId(user.getId());
        house.setIsdel(0);
        house.setPath(name);
        house.setPubdate(new Date());
        house.setId(System.currentTimeMillis()+"");

        int i = houseService.insertSelective(house);
        if(i>0){
            return "redirect:selectAllHouseExcByUserId";
        }
        else {
             file.delete();
             return "redirect:publish";
        }
    }
//根据用户ID查询所有房屋信息
    @RequestMapping("selectAllHouseExcByUserId")
    public String selectAllHouseExcByUserId(Integer page,Integer rows,HttpSession session,Model model){
        Users user = (Users) session.getAttribute("user");
        Integer userId = user.getId();

        PageInfo<HouseExc> pageInfo = houseService.selectAllHouseExcByUserId(page==null?1:page, rows==null?4:rows, userId);

        model.addAttribute("pageInfo",pageInfo);

        return "page/guanli";
    }
    /*@RequestMapping("updateByPrimaryKeySelective")
    public String updateByPrimaryKeySelective(House house){
        int i = houseService.updateByPrimaryKeySelective(house);
        return "redirect:selectAllHouseExcByUserId";
    }*/
//退出系统清除用户信息
    @RequestMapping("outSystem")
    public String outSystem(HttpSession session){
   session.removeAttribute("user");
   return "page/login";
    }


    //房屋信息修改
    @RequestMapping("updateHouse")
    public String updateHouse(String id,Model model){

        //查询所有类型和区域信息
        List<Type> types = typeService.selectByExample();
        List<District> districts = districtService.selectAllDistrict();

        //通过房屋编号查询房屋信息
        HouseExc houseExc = houseService.selectByHouseId(id);

        model.addAttribute("types",types);
        model.addAttribute("districts",districts);
        model.addAttribute("houseExc",houseExc);
        return "page/updatefabu";
    }
             @RequestMapping("updateHouseDo")
         public String updateHouseDo(String oldPath ,House house,@RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile) throws IOException {

                 File fileOld=new File("G:\\zuoye\\"+oldPath);

                String originalName= pfile.getOriginalFilename();
                String name=originalName.substring(originalName.lastIndexOf("."));
                String nameSure=System.currentTimeMillis()+name;
                house.setPath(nameSure);


                 File fileNew=new File("G:\\zuoye\\"+nameSure);
                 pfile.transferTo(fileNew);

                 int i = houseService.updateByPrimaryKeySelective(house);
                 if(i>0){
                     if(!pfile.getOriginalFilename().equals(""))
                     {  fileOld.delete();
                     }else {
                         fileNew.delete();
                     }

                 }
                 return "redirect:selectAllHouseExcByUserId"; }

        //查询所有房屋类型区域街道
    @RequestMapping("selectAllTDS")
    @ResponseBody
    public Map<String,Object> selectAllTDS(){
        //查询所有房屋类型
        List<Type> types = typeService.selectAllType();

        //查询所有区域
        List<District> districts = districtService.selectAllDistrict();



       Map<String,Object>map=new HashMap<>();
       map.put("types",types);
       map.put("districts",districts);

       return map;
    }

    //查询所有已审核房屋

    @RequestMapping("selectByCondition")
    public String selectByCondition( HouseCondition houseCondition,Model model){
        System.out.println(houseCondition);
        houseCondition.setPage(houseCondition.getPage()==null?1:houseCondition.getPage());
        PageInfo<HouseExc> pageInfo = houseService.selectByCondition(houseCondition);
        System.out.println(pageInfo.getList().size());


        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("houseCondition",houseCondition);

        return "page/list";
    }
}
