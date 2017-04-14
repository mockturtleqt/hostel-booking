package com.epam.javalab.hostelbooking.service;

import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;

public interface UserService {
    User createUser(User user) throws ServiceException;

    User findUserByLoginAndPassword(String login, String password) throws ServiceException;

    User changeUserPassword(int userId, String password) throws ServiceException;

    boolean resetUserPassword(int userId, String resetKey, String newPassword) throws ServiceException;

    String generateResetKey(int id, String login, String email) throws ServiceException;

    User updateUserProfile(User user) throws ServiceException;

}
