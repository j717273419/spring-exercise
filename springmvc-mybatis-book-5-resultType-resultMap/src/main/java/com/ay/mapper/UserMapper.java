package com.ay.mapper;

import com.ay.dto.UserClass;
import com.ay.pojo.Tb_User;

import java.util.List;

public interface UserMapper {
    public List<UserClass> selectUser(String username);
}
