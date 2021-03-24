package com.ay.mapper;

import com.ay.pojo.Tb_User;

import java.util.List;

public interface UserMapper {
    public List<Tb_User> selectUser();
    public void addUser();
    public void updateUser();
    public void deleteUser();
}
