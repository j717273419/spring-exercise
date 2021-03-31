package com.wangdongjie.springmvc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloRestCurdHandler {

    //url
    //http://localhost:8080/jsonCurd
    @RequestMapping(value = "/jsonCurd",method = RequestMethod.GET)
    public String jsonCurd(int a,int b){
        System.out.println("执行了jsonCurd get");
        int result = a + b;
        return String.valueOf(result);
    }

    //url
    //http://localhost:8080/jsonCurd
    @RequestMapping(value = "/jsonCurd",method = RequestMethod.POST)
    public String jsonCurdPost(int a,int b){
        System.out.println("执行了jsonCurd post");
        int result = a * b;
        return String.valueOf(result);
    }

    //url
    //http://localhost:8080/jsonCurd
    @RequestMapping(value = "/jsonCurdPostParam",method = RequestMethod.POST)
    public String jsonCurdPostParam(String params){
        System.out.println("执行了jsonCurd post");
        int result = 2;
        return String.valueOf(result);
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public User user(){
        User user = new User();
        user.setId(1);
        user.setAge(18);
        user.setName("lucas");
        return  user;
    }

    @RequestMapping(value = "/users")
    @ResponseBody
    public List<User> users(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(18);
            user.setName("lucas");
            users.add(user);
        }
        return  users;
    }

    @RequestMapping("/map")
    @ResponseBody
    public Map<String, Object> map() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "lucas");
        map.put("age", 18);
        return map;
    }

    @PostMapping("/jsonrequest")
    @ResponseBody
    public Map<String, Object>  jsonrequest(@RequestBody User user) {
        System.out.println("jsonrequest");
        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "请求成功");
        map.put("data", user);
        return  map;
    }

    @PostMapping("/jsonobjPost")
    @ResponseBody
    public Map<String, Object>  jsonobjPost(@RequestParam int id,@RequestParam int age, @RequestParam String name) {
        System.out.println("jsonobjPost");
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "请求成功");
        map.put("data", user);
        return  map;
    }
}
