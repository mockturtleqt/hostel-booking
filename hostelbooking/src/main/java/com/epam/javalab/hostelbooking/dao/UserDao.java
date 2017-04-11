package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.domain.User;

import java.util.List;

public interface UserDao {
    //User getUserName(String login, String password);

    User createUser(User user);

    User findUserByLoginAndPassword(String login, String password);

    List<User> findAllUsers();

    User updateUser(User user);


}
