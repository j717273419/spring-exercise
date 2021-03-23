package com.ay.test;

import com.ay.mapper.UserMapper;
import com.ay.pojo.Tb_User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void test() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream((resources));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("Create:");
        mapper.addUser();
        List<Tb_User> userListAdd = mapper.selectUser();
        for(Tb_User user: userListAdd){
            System.out.println(user.getUsername() + ","+ user.getPassword());
        }
        sqlSession.clearCache();
        System.out.println("Update:");
        mapper.updateUser();

        List<Tb_User> userListUpdate = mapper.selectUser();
        for(Tb_User user: userListUpdate){
            System.out.println(user.getUsername() + ","+ user.getPassword());
        }

        System.out.println("Read:");
        List<Tb_User> userListRead = mapper.selectUser();
        for(Tb_User user: userListRead){
            System.out.println(user.getUsername() + ","+ user.getPassword());
        }

        System.out.println("Delete:");
        mapper.deleteUser();
        sqlSession.clearCache();
        List<Tb_User> userListDelete = mapper.selectUser();
        for(Tb_User user: userListDelete){
            System.out.println(user.getUsername() + ","+ user.getPassword());
        }
    }
}
