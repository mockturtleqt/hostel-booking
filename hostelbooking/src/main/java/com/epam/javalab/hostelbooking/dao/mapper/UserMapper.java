package com.epam.javalab.hostelbooking.dao.mapper;

import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.domain.type.GenderType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    private static final String USER_ID = "user_id";
    private static final String USER_FIRST_NAME = "user_first_name";
    private static final String USER_LAST_NAME = "user_last_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_LOGIN = "user_login";
    private static final String USER_PASSWORD = "user_password";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_AGE = "user_age";
    private static final String USER_CARD_NUMBER = "user_card_number";

    public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt(USER_ID));
        user.setFirstName(resultSet.getString(USER_FIRST_NAME));
        user.setLastName(resultSet.getString(USER_LAST_NAME));
        user.setEmail(resultSet.getString(USER_EMAIL));
        user.setLogin(resultSet.getString(USER_LOGIN));
        user.setPassword(resultSet.getString(USER_PASSWORD));
        
        String gender = resultSet.getString(USER_GENDER);
        if (gender != null) {
            user.setGender(GenderType.valueOf(gender.toUpperCase()));
        }

        user.setAge(resultSet.getInt(USER_AGE));
        user.setCardNumber(resultSet.getLong(USER_CARD_NUMBER));

        return user;
    }
}
