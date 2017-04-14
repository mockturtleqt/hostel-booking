package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.UserService;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;
import com.epam.javalab.hostelbooking.service.exception.ValidationException;
import com.epam.javalab.hostelbooking.service.validation.UserValidation;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {

    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) throws ServiceException {
        try {
            if (isValid(user)) {
                user = userDao.createUser(user);
            }
            return user;
        } catch (ValidationException e) {
            throw new ServiceException("Cannot create user due to invalid data: ", e);
        } catch (DaoException e) {
            throw new ServiceException("Cannot create user ", e);
        }
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return userDao.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            throw new ServiceException("Cannot find user ", e);
        }
    }

    @Override
    public User changeUserPassword(int userId, String password) throws ServiceException {
        try {
            User user = userDao.findUserById(userId);
            user.setPassword(password);
            userDao.updateUserProfile(user);
            return user;
        } catch (DaoException e) {
            throw new ServiceException("Cannot change user password ", e);
        }
    }

    @Override
    public String generateResetKey(int id, String login, String email) throws ServiceException {
        try {
            String resetKey = null;
            User user = userDao.findUserById(id);
            if (user.getLogin().equals(login) && user.getEmail().equals(email)) {
                resetKey = RandomStringUtils.randomAlphanumeric(10);
                user.setResetKey(resetKey);
                userDao.updateUserProfile(user);
            }
            return resetKey;
        } catch (DaoException e) {
            throw new ServiceException("Cannot generate a reset key  ", e);
        }
    }

    /**
     * To reset a password user must provide his email and login. Then if the data is correct, the
     * reset key will be generated, set in database and sent to user.
     * User will be able to update his password using this reset key.
     * @param userId
     * @param resetKey that is generated by the generateResetKey() method
     * @param newPassword
     * @return true if the password was reset, false otherwise
     * @throws ServiceException
     */
    @Override
    public boolean resetUserPassword(int userId, String resetKey, String newPassword) throws ServiceException {
        try {
            boolean success;
            User user = userDao.findUserById(userId);
            if (user.getResetKey() != null && user.getResetKey().equals(resetKey)) {
                user.setPassword(newPassword);
                userDao.updateUserProfile(user);
                success = true;
            } else {
                success = false;
            }
            return success;
        } catch (DaoException e) {
            throw new ServiceException("Cannot reset password ");
        }
    }

    @Override
    public User updateUserProfile(User newUser) throws ServiceException {
        try {
            if (isValid(newUser)) {
                userDao.updateUserProfile(newUser);
            }
            return newUser;
        } catch (ValidationException e) {
            throw new ServiceException("Cannot update user due to invalid data: ", e);
        } catch (DaoException e) {
            throw new ServiceException("Cannot update user ", e);
        }
    }

    private boolean isValid(User user) throws ValidationException {
        UserValidation userValidation = new UserValidation();
        if (userValidation.isValid(user)) {
            return true;
        } else {
            throw new ValidationException("Invalid fields: \n" + userValidation.getExceptions());
        }
    }
}
