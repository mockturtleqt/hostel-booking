package com.epam.javalab.hostelbooking.dao.jdbc.query;

public class UserQuery {
    public static final String SQL_FIND_ALL_USERS = "SELECT user_id, user_first_name, " +
            "user_last_name, user_email, user_login, user_password, user_gender, user_age, " +
            "user_card_number, user_reset_key FROM users";

    public static final String SQL_FIND_USER_BY_ID = "SELECT user_id, user_first_name, user_last_name, " +
            "user_email, user_login, user_password, user_gender, user_age, user_card_number, user_reset_key" +
            " FROM users WHERE user_id = ?";

    public static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT user_id, user_first_name, " +
            "user_last_name, user_email, user_login, user_password, user_gender, user_age, user_card_number, " +
            "user_reset_key FROM users WHERE user_login = ? AND user_password = ?";

    public static final String SQL_INSERT_USER = "INSERT INTO users (user_first_name, user_last_name, user_email, " +
            "user_login, user_password, user_gender, user_age, user_card_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

//    public static final String SQL_UPDATE_RESET_KEY = "UPDATE users SET user_reset_key = ? WHERE user_id = ?";

//    public static final String SQL_UPDATE_PASSWORD = "UPDATE users SET user_password = ? WHERE user_id = ?";

    public static final String SQL_UPDATE_USER_PROFILE = "UPDATE users SET user_first_name = ?, " +
            "user_last_name = ?, user_email = ?, user_login = ?, user_password = ?, user_reset_key = ?," +
            "user_gender = ?, user_age = ?, user_card_number = ? WHERE user_id = ?";

}
