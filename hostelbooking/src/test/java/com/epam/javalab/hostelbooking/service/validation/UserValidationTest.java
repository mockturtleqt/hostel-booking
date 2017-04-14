package com.epam.javalab.hostelbooking.service.validation;

import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.exception.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

public class UserValidationTest {

    private UserValidation userValidation;
    private User correctUser;
    private User incorrectUser;

    @Before
    public void setUp() {
        userValidation = new UserValidation();

        correctUser = new User();
        correctUser.setId(1);
        correctUser.setFirstName("Galia");
        correctUser.setLastName("Semashka");
        correctUser.setLogin("mockturtlee");
        correctUser.setPassword("123Mockturtle");
        correctUser.setEmail("galia.semashko@mail.com");

        incorrectUser = new User();
        incorrectUser.setId(2);
        incorrectUser.setFirstName("123");
        incorrectUser.setLastName("Semashka");
        incorrectUser.setLogin("mockturtlee");
        incorrectUser.setPassword("123Mockturtle");
        incorrectUser.setEmail("galia.semashko@mail.com");

    }

    @Test
    public void isValid_invalidName_False() throws Exception {
        userValidation.isValid(incorrectUser);
        assertEquals(userValidation.getExceptions().size(), 1);
    }

    @Test
    public void isValid_validUser_True() throws Exception {
        userValidation.isValid(correctUser);
        assertEquals(userValidation.getExceptions().size(), 0);
    }

}