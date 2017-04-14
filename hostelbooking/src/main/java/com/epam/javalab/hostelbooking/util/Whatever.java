package com.epam.javalab.hostelbooking.util;

import com.epam.javalab.hostelbooking.config.HostelBookingConfiguration;
import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.UserService;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Whatever {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext =
                new AnnotationConfigApplicationContext(HostelBookingConfiguration.class);

        UserDao userDao = configApplicationContext.getBean(UserDao.class);

        UserService userService = configApplicationContext.getBean(UserService.class);


        // User username = userDao.getUserName("kperkins0", "XasrYzv");
        //System.out.println("Name " + username);
        //System.out.println(userDao.findUserByLoginAndPassword("kperkins0", "hey123"));
        // System.out.println(userService.findUserByLoginAndPassword("kperkins0", "hey123"));
        User user = new User();
        user.setFirstName("Halina");
        user.setLastName("Semashka");
        user.setLogin("mockturtlee");
        user.setPassword("123Mockturtle");
        user.setEmail("galia.semashko@mail.com");
        user.setCardNumber(1234567);
        try {
            System.out.println(userService.updateUserProfile(user));
        } catch (ServiceException e) {
            System.out.println(e);
        }
        //System.out.println(userService.updateUserProfile(user));

//        User user = new User();
//        user.setEmail("dreyes0@addthis.com");
//        user.setPassword("E83LQpI");
//        //System.out.println(userDao.findUserByLoginAndPassword(user));
//        System.out.println(userDao.findAllUsers());

        configApplicationContext.close();
    }
}
