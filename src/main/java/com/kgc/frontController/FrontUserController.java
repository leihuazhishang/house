package com.kgc.frontController;

import com.kgc.entity.Users;
import com.kgc.service.UsersService;
import com.kgc.util.HttpClientUtil;
import com.kgc.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;


@Controller
@RequestMapping("/frontUser/")
public class FrontUserController {
    @Autowired
    private UsersService usersService;

    //登录
    @RequestMapping("selectByExample2")
    public String selectByExample2(String name, String password, Model model, HttpSession session){



            Users user = usersService.selectByExample2(name, password);

            if(user!=null){
                session.setAttribute("user",user);
                session.setMaxInactiveInterval(600);
                return "redirect:/house/selectAllHouseExcByUserId";

            }else {
                model.addAttribute("info","用户名或密码错误，请重新登录");
                return "page/login";
               }



    }
    //获取短信验证码

    @RequestMapping("getCode")
    @ResponseBody
    public String getCode(HttpSession session,String smsMob){
        System.out.println("hello");
        //6位验证码
        int code=(int)(Math.random()*1000000);
        session.setAttribute("code",code);
        session.setMaxInactiveInterval(600);

        String smsText="您的验证码是"+code;

        int i = SmsUtil.sendMsm(smsMob, smsText);
        System.out.println(i);
        return "{\"result\":"+i+"}";


    }

    //前台用户注册
    @RequestMapping("insert")
    public String frontInsert(String code, Users user,HttpSession session,Model model){

        String code1 = session.getAttribute("code").toString();


        if(code1.equals(code)){
            int i = usersService.frontInsert(user);
            if(i>0){
                return  "page/login";
            }
            return "page/regs";
        }else {
            model.addAttribute("speak","验证码错误，请重新输入");
            return "page/regs";
        }


    }

    //通过用户名查询
    @RequestMapping("selectByUserName")
    @ResponseBody
    public String selectByUserName(String name){
        int i = usersService.selectByExample1(name);
        return "{\"result\":"+i+"}";
    }



}
