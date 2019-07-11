package com.kgc.exce;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class AllException {

    @ExceptionHandler(Exception.class)
    public String allException(Exception e){
        e.printStackTrace();
        return "redirect:/admin/js/error.jsp";
    }


}
