package com.ay.test;

import com.ay.mapper.UserMapper;
import com.ay.pojo.Tb_User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void test() throws IOException {
        String configFile = "spring-mybatis-config.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configFile);
        SqlSessionTemplate sqlSessionTemplate = context.getBean("sqlsessionTemplate", SqlSessionTemplate.class);
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);

        System.out.println("Create:");
        mapper.addUser();
        List<Tb_User> userListAdd = mapper.selectUser();
        for(Tb_User user: userListAdd){
            System.out.println(user.getUsername() + ","+ user.getPassword());
        }

        System.out.println("Read:");
        List<Tb_User> userListRead = mapper.selectUser();
        for(Tb_User user: userListRead){
            System.out.println(user.getUsername() + ","+ user.getPassword());
        }

    }
}
