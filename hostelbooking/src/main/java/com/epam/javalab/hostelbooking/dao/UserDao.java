package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.User;

import java.util.List;

public interface UserDao {

    User createUser(User user) throws DaoException;

    User findUserById(int id) throws DaoException;

    User findUserByLoginAndPassword(String login, String password) throws DaoException;

    List<User> findAllUsers() throws DaoException;

    User updateUserProfile(User user) throws DaoException;
//
//    boolean updateUserPassword(User user, String password);
//
//    boolean setResetKey(User user, String resetKey);
}
