package com.wangdongjie.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestHandler {

    //url
    //http://localhost:8080/jsonDemo
    @RequestMapping("/jsonDemo")
    public String jsonDemo(){
        System.out.println("执行了jsonDemo");
        return "json data";
    }
}
