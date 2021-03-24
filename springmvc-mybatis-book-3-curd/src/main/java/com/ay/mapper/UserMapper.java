package com.ay.mapper;

import com.ay.dto.UserDto;
import com.ay.pojo.Tb_User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<Tb_User> selectUser();
    public List<Tb_User> selectUserByName(String username, String password);
    public List<Tb_User> selectUserByParam(@Param("uname")String username, @Param("pwd") String password);
    public List<Tb_User> selectUserByMap(Map<String,String> map);
    public List<Tb_User> selectUserByBean(UserDto model);
    public int addUser(Tb_User model);
    public int updateUser(Tb_User model);
    public int deleteUser(String username);
}
