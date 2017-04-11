package com.epam.javalab.hostelbooking.util.jdbc.query;

public class UserQuery {
    public static final String SQL_FIND_ALL_USERS = "SELECT user_id, user_first_name, " +
            "user_last_name, user_email, user_login, user_password, user_gender, user_age, user_card_number FROM users";

    public static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT user_id, user_first_name, user_last_name, " +
            "user_email, user_login, user_password, user_gender, user_age, user_card_number FROM users " +
            "WHERE user_login = ? AND user_password = ?";

    public static final String SQL_INSERT_USER = "INSERT INTO users (user_first_name, user_last_name, user_email, " +
            "user_login, user_password, user_gender, user_age, user_card_number) VALUES ('?', '?', '?', '?', '?', ?, ?)";


}
