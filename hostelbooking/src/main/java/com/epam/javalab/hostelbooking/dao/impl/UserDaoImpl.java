package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.dao.mapper.UserMapper;
import com.epam.javalab.hostelbooking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        jdbcTemplate.update(SQL_INSERT_USER, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getLogin(), user.getPassword(), user.getGender().name(), user.getAge(),
                user.getCardNumber());
        return user;
//        try {
//            //TODO add getting auto-generated id
//            jdbcTemplate.update(SQL_INSERT_USER, user.getFirstName(), user.getLastName(),
//                    user.getEmail(), user.getLogin(), user.getPassword(), user.getGender().name(), user.getAge(),
//                    user.getCardNumber());
//            return user;
//        } catch (DataAccessException e) {
//            throw new DaoException("Cannot create user ", e);
//        }
    }

    @Override
    public User findUserById(int id) throws DaoException {
        List<User> users = jdbcTemplate.query(SQL_FIND_USER_BY_ID, new Object[]{id}, new UserMapper());
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            throw new DaoException("Cannot find this user");
        }
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DaoException {
        List<User> users = jdbcTemplate.query(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD,
                new Object[]{login, password}, new UserMapper());
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            throw new DaoException("Cannot find this user");
        }
    }

    @Override
    public List<User> findAllUsers() throws DaoException {
        List<User> users = jdbcTemplate.query(SQL_FIND_ALL_USERS, new UserMapper());
        if (!users.isEmpty()) {
            return users;
        } else {
            throw new DaoException("There are no users in database");
        }
    }

    @Override
    public User updateUserProfile(User user) throws DaoException {
        jdbcTemplate.update(SQL_UPDATE_USER_PROFILE, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getLogin(), user.getPassword(), user.getResetKey(),
                user.getGender().name(), user.getAge(), user.getCardNumber(), user.getId());
        return user;
//        try {
//            jdbcTemplate.update(SQL_UPDATE_USER_PROFILE, user.getFirstName(), user.getLastName(),
//                    user.getEmail(), user.getLogin(), user.getPassword(), user.getResetKey(),
//                    user.getGender().name(), user.getAge(), user.getCardNumber(), user.getId());
//            return user;
//        } catch (DataAccessException e) {
//            throw new DaoException("Cannot update user ", e);
//        }
    }
}
