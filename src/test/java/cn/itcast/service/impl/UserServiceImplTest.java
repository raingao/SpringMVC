package cn.itcast.service.impl;

import cn.itcast.bean.MapTest;
import cn.itcast.pojo.Admin;
import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by gaoyu on 2017/6/6.
 * Wish you a good day~
 */
public class UserServiceImplTest {

    private UserService userServiceImpl;

    @Test
    public void findUserByUserName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
        userServiceImpl = (UserService) context.getBean("userService");
        System.out.println(userServiceImpl);
        Admin admin = userServiceImpl.findUserByUserName("gaoyu");
        System.out.println(admin.toString());
    }

    @Test
    public void findRoleIdByUserName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext-service.xml");
        MapTest test = (MapTest) context.getBean("maptest");
        System.out.println(test.getMap());
    }

    @Test
    public void jdbcTest() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "123456");

            String sql = "select * from user where uid = 1";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("uid").substring(1) + resultSet.getString("username") + resultSet.getString("email"));
            }

            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}