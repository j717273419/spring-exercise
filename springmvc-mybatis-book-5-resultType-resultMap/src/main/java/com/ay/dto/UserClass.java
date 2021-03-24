package com.ay.dto;

public class UserClass {
    private int userid;
    private String username;
    private String password;
    private String classname;

    @Override
    public String toString() {
        return "userid:"+this.userid+",username:"+this.username+",password:"+this.password+",classname:"+this.classname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
