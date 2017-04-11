package com.epam.javalab.hostelbooking.util;

import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.util.jdbc.SpringJDBCConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Whatever {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(SpringJDBCConfiguration.class);

        UserDao userDao = configApplicationContext.getBean(UserDao.class);
       // User username = userDao.getUserName("kperkins0", "XasrYzv");
        //System.out.println("Name " + username);
        System.out.println(userDao.findUserByLoginAndPassword("kperkins0", "XasrYzv"));

//        User user = new User();
//        user.setEmail("dreyes0@addthis.com");
//        user.setPassword("E83LQpI");
//        //System.out.println(userDao.findUserByLoginAndPassword(user));
//        System.out.println(userDao.findAllUsers());

        configApplicationContext.close();
    }
}
