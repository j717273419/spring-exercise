package com.wangdongjie.springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndViewTestHandler implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        System.out.println("执行ModelAndViewTest");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","ControllerTest1");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
