package com.wangdongjie.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello2Handler {

    //url
    //http://localhost:8080/h2
    @RequestMapping("/h2")
    public String hello2(Model model)
    {
        model.addAttribute("msg","Hello, SpringMVC");
        System.out.println("执行了hello2");
        return "ModelDemo";
    }
}
