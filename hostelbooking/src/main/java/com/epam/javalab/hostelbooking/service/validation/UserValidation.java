package com.epam.javalab.hostelbooking.service.validation;

import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {
    private static final String LOGIN_PATTERN = "^([a-zA-Z]+)[a-zA-Z\\d_]{4,30}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,50}$";
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9.]+@[a-zA-Z.]+";
    private static final String NAME_PATTERN = "[a-zA-Z]+";
    private static final int EMAIL_LENGTH = 50;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 150;

    private List<ValidationException> exceptions = new ArrayList<>();

    public boolean isValid(User user) {
        boolean valid = true;

        if (!isNameValid(user.getFirstName())) {
            exceptions.add(new ValidationException("Invalid first name "));
            valid = false;
        }
        if (!isNameValid(user.getLastName())) {
            exceptions.add(new ValidationException("Invalid last name "));
            valid = false;
        }
        if (!isEmailValid(user.getEmail())) {
            exceptions.add(new ValidationException("Invalid email "));
            valid = false;
        }
        if (!isLoginValid(user.getLogin())) {
            exceptions.add(new ValidationException("Invalid login "));
            valid = false;
        }
        if (!isPasswordValid(user.getPassword())) {
            exceptions.add(new ValidationException("Invalid password "));
            valid = false;
        }
        if (!isAgeValid(user.getAge())) {
            exceptions.add(new ValidationException("Invalid age "));
            valid = false;
        }

        return valid;
    }

    public List<ValidationException> getExceptions() {
        return exceptions;
    }

    private boolean isStringValid(String string) {
        return (string != null) && (!string.isEmpty());
    }

    private boolean isNameValid(String name) {
        return (isStringValid(name) && name.matches(NAME_PATTERN));
    }

    private boolean isEmailValid(String email) {
        return (isStringValid(email) && email.matches(EMAIL_PATTERN) && email.length() < EMAIL_LENGTH);
    }

    private boolean isLoginValid(String login) {
        return (isStringValid(login) && login.matches(LOGIN_PATTERN));
    }

    private boolean isPasswordValid(String password) {
        return (isStringValid(password) && password.matches(PASSWORD_PATTERN));
    }

    private boolean isAgeValid(int age) {
        return age >= MIN_AGE && age <= MAX_AGE;
    }
}
