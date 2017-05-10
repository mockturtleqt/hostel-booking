package com.epam.javalab.hostelbooking.service;

import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;

public interface UserService extends EntityService<User> {

    User findByLoginAndPassword(String login, String password) throws ServiceException;

    User changePassword(int userId, String password) throws ServiceException;

    boolean resetPassword(int userId, String resetKey, String newPassword) throws ServiceException;

    String generateResetKey(int id, String login, String email) throws ServiceException;

}
