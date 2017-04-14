package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.dao.mapper.UserMapper;
import com.epam.javalab.hostelbooking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.epam.javalab.hostelbooking.dao.jdbc.query.UserQuery.*;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl() {
    }

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createUser(User user) throws DaoException {
        try {
            //TODO add auto-generated id
            jdbcTemplate.update(SQL_INSERT_USER, user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.getLogin(), user.getPassword(), user.getGender(), user.getAge(),
                    user.getCardNumber());
            return user;
        } catch (DataAccessException e) {
            throw new DaoException("Cannot create user ", e);
        }
    }

    @Override
    public User findUserById(int id) throws DaoException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_USER_BY_ID,
                    new Object[]{id}, new UserMapper());
        } catch (DataAccessException e) {
            throw new DaoException("Cannot find user ", e);
        }

    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DaoException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD,
                    new Object[]{login, password}, new UserMapper());
        } catch (DataAccessException e) {
            throw new DaoException("Cannot find user ", e);
        }
    }

    @Override
    public List<User> findAllUsers() throws DaoException {
        try {
            return jdbcTemplate.query(SQL_FIND_ALL_USERS, new UserMapper());
        } catch (DataAccessException e) {
            throw new DaoException("Cannot find user ", e);
        }
    }

    @Override
    public User updateUserProfile(User user) throws DaoException {
        try {
            jdbcTemplate.update(SQL_UPDATE_USER_PROFILE, user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.getLogin(), user.getPassword(), user.getResetKey(),
                    user.getGender(), user.getAge(), user.getCardNumber(), user.getId());
            return user;
        } catch (DataAccessException e) {
            throw new DaoException("Cannot create user ", e);
        }
    }
}
