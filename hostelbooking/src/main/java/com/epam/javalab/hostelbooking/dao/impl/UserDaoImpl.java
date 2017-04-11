package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.dao.mapper.UserMapper;
import com.epam.javalab.hostelbooking.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.epam.javalab.hostelbooking.util.jdbc.query.UserQuery.SQL_FIND_ALL_USERS;
import static com.epam.javalab.hostelbooking.util.jdbc.query.UserQuery.SQL_FIND_USER_BY_LOGIN_AND_PASSWORD;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public User getUserName(String login, String password) {
//        String sql = "SELECT * from users where user_login = ? and user_password = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{login, password}, new UserMapper());
//    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        return jdbcTemplate.queryForObject(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD,
                new Object[]{login, password}, new UserMapper());
    }

    @Override
    public List<User> findAllUsers() {
        return jdbcTemplate.query(SQL_FIND_ALL_USERS, new UserMapper());
    }


    @Override
    public User updateUser(User user) {
        return null;
    }
}
