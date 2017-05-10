package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.User;

public interface UserDao extends EntityDao<User> {

    User findByLoginAndPassword(String login, String password) throws DaoException;

}
