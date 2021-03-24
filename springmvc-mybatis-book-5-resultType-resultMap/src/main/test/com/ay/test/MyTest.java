package com.ay.test;

import com.ay.dto.UserClass;
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

        System.out.println("Read:");
        String username = "foo";
        List<UserClass> userListRead = mapper.selectUser(username);
        for(UserClass user: userListRead){
            System.out.println(user);
        }
    }
}
