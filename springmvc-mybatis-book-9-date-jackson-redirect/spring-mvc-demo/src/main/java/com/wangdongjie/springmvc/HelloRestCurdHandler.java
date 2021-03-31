package com.wangdongjie.springmvc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @GetMapping(value = "/user2")
    public User user2(){
        User user = new User();
        user.setId(12);
        user.setAge(182);
        user.setName("lucas2");
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

    //返回日期
    //output:
    //1617202917164
    @GetMapping(value = "/getdate")
    public Date getdate(){
        Date date = new Date();
        return date;
    }

    //返回格式化后的日期
    //output:
    //2021-03-31 23:02:25
    @GetMapping(value = "/getdate2")
    public String getdate2(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
        return simpleDateFormat.format(date);
    }

    //对象有日期字段
    //output
    //{"age":182,"birthDay":1617203866681,"id":12,"name":"lucas2"}
    @GetMapping(value = "/userdate")
    public User userdate(){
        User user = new User();
        user.setId(12);
        user.setAge(182);
        user.setName("lucas2");
        user.setBirthDay(new Date());
        return  user;
    }

    //
    @GetMapping(value = "/userdateformat")
    public String userdateformat() throws IOException {
        User user = new User();
        user.setId(12);
        user.setAge(182);
        user.setName("lucas2美国");
        user.setBirthDay(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        System.out.println("输出json对象");
        jsonGenerator.writeObject(user);
        ObjectWriter objectWriter = objectMapper.writerWithView(User.class);
        String jsonstr = objectWriter.writeValueAsString(user);
        return  jsonstr;
    }

    //{"name":"lucas2美国","id":12,"birthDay":"2021-04-01 00:54","age":182}
    @GetMapping(value = "/userdateformat2")
    public String userdateformat2() throws IOException {
        User user = new User();
        user.setId(12);
        user.setAge(182);
        user.setName("lucas2美国");
        user.setBirthDay(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        objectMapper.setDateFormat(df);
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        System.out.println("输出json对象");
        jsonGenerator.writeObject(user);
        ObjectWriter objectWriter = objectMapper.writerWithView(User.class);
        String jsonstr = objectWriter.writeValueAsString(user);
        return  jsonstr;
    }

    @GetMapping(value = "/jsonstr")
    public String jsonstr() throws IOException {
        User user = new User();
        user.setId(12);
        user.setAge(182);
        user.setName("lucas2美国");
        user.setBirthDay(new Date());
        user.setResignDate(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        System.out.println("输出json对象");
        jsonGenerator.writeObject(user);
        ObjectWriter objectWriter = objectMapper.writerWithView(User.class);
        String jsonstr = objectWriter.writeValueAsString(user);
        return  jsonstr;
    }
}
