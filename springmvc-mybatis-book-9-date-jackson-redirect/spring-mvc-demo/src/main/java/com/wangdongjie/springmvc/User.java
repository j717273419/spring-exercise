package com.wangdongjie.springmvc;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class User {
    private int Id;
    private int Age;
    private String Name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date BirthDay;

    private Date ResignDate;

    public Date getBirthDay(){
        return BirthDay;
    }


    public void setBirthDay(Date birthDay){
        BirthDay = birthDay;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getResignDate() {
        return ResignDate;
    }

    public void setResignDate(Date resignDate) {
        ResignDate = resignDate;
    }
}
