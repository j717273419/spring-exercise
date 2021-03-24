package com.ay.test;

import com.ay.dto.UserDto;
import com.ay.mapper.UserMapper;
import com.ay.pojo.Tb_User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.test.web.reactive.server.JsonPathAssertions;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void test() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream((resources));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        System.out.println("Create:");
//        Tb_User userCreate = new Tb_User();
//        userCreate.setUsername("foo");
//        userCreate.setPassword("bar");
//        int resultCreate = mapper.addUser(userCreate);
//        System.out.println("create before result:" + String.valueOf(resultCreate));
//        sqlSession.commit();
//        System.out.println("create after result:"  + String.valueOf(resultCreate));
//        List<Tb_User> userListAdd = mapper.selectUser();
//        for(Tb_User user: userListAdd){
//            System.out.println(user.getUsername() + ","+ user.getPassword());
//        }
//        System.out.println("Update:");
//        Tb_User userUpdate = new Tb_User();
//        userUpdate.setUsername("wdj2024");
//        userUpdate.setPassword("666");
//        int resultUpdate = mapper.updateUser(userUpdate);
//        System.out.println("update before result:"+String.valueOf(resultUpdate));
//        sqlSession.commit();
//        System.out.println("update after result:"+String.valueOf(resultUpdate));
//        List<Tb_User> userListUpdate = mapper.selectUser();
//        for(Tb_User user: userListUpdate){
//            System.out.println(user.getUsername() + ","+ user.getPassword());
//        }
//
//        System.out.println("Read:");
//        List<Tb_User> userListRead = mapper.selectUser();
//        for(Tb_User user: userListRead){
//            System.out.println(user.getUsername() + ","+ user.getPassword());
//        }
//
//        System.out.println("Delete:");
//        String username = "wdj2024";
//        int resultDelete = mapper.deleteUser(username);
//        System.out.println("delete before result:"+String.valueOf(resultDelete));
//        sqlSession.commit();
//        System.out.println("delete before result:"+String.valueOf(resultDelete));
//        List<Tb_User> userListDelete = mapper.selectUser();
//        for(Tb_User user: userListDelete){
//            System.out.println(user.getUsername() + ","+ user.getPassword());
//        }
//
//
//        //测试根据多参数查询sql
//        System.out.println("Read:");
//        String username = "foo";
//        String password = "bar2";
//        List<Tb_User> listRead = mapper.selectUserByName(username,password);
//        System.out.println("read result:"+String.valueOf(listRead.size()));
//        for(Tb_User user: listRead){
//            System.out.println(user.getUsername() + ","+ user.getPassword());
//        }

//
//        //测试根据多参数查询sql
//        System.out.println("Read:");
//        String username = "foo";
//        String password = "bar2";
//        List<Tb_User> listRead = mapper.selectUserByParam(username,password);
//        System.out.println("read result:"+String.valueOf(listRead.size()));
//        for(Tb_User user: listRead){
//            System.out.println(user.getUsername() + ","+ user.getPassword());
//        }

//        //测试根据多参数查询sql
//        System.out.println("Read:");
//        Map<String,String> map = new HashMap<>();
//        String username = "foo";
//        map.put("keyUserName",username);
//        String password = "bar2";
//        map.put("keyPassword",password);
//        List<Tb_User> listRead = mapper.selectUserByMap(map);
//        System.out.println("read by map result:"+String.valueOf(listRead.size()));
//        for(Tb_User user: listRead){
//            System.out.println(user.getUsername() + ","+ user.getPassword());
//        }

        //测试根据多参数查询sql
        System.out.println("Read:");
        UserDto userDto = new UserDto();
        userDto.setUsername("foo");
        userDto.setPassword("bar2");
        List<Tb_User> listRead = mapper.selectUserByBean(userDto);
        System.out.println("read by bean result:"+String.valueOf(listRead.size()));
        for(Tb_User user: listRead){
            System.out.println(user.getUsername() + ","+ user.getPassword());
        }
    }
}
