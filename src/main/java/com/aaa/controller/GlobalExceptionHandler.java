package com.aaa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    public static final String DEFAULT_ERROR_VIEW = "error";
    
   /* @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView businessExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        
        return mav;
    }*/
    
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Map<String, String> jsonExceptionHandler(HttpServletRequest req, Exception e) {
        Map<String, String> re = new HashMap<>();
        re.put("error", "500");
        re.put("msg","程序员正在送货");
        return re;
    }
    
}
