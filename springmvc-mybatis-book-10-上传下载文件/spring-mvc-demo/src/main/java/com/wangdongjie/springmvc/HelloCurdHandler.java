package com.wangdongjie.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloCurdHandler {

    //url
    //http://localhost:8080/curd
    @RequestMapping("/curdtest")
    public String curd(Model model)
    {
        model.addAttribute("msg","Hello, curd default");
        System.out.println("执行了hello2");
        return "ModelDemo";
    }

    @RequestMapping(value="/curd",method = RequestMethod.GET)
    public String curdGet(Model model)
    {
        model.addAttribute("msg","Hello, curd RequestMethod.GET");
        System.out.println("执行了hello2");
        return "ModelDemo";
    }

    @RequestMapping(value="/curd",method = RequestMethod.POST)
    public String curdPost(String params, Model model)
    {
        System.out.println("curd执行了curdPost");
        System.out.println("curd执行了curdPost params:"+params);
        model.addAttribute("msg","Hello, curd RequestMethod.POST");
        model.addAttribute("params",params);
        return "ModelCurdDemo";
    }
}
