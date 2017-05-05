package com.epam.javalab.hostelbooking.service.validation;

import com.epam.javalab.hostelbooking.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void isValid_InvalidNameGiven_ShouldReturnFalse() throws Exception {
        userValidation.isValid(incorrectUser);
        assertEquals(1, userValidation.getExceptions().size());
    }

    @Test
    public void isValid_ValidUserGiven_ShouldReturnTrue() throws Exception {
        userValidation.isValid(correctUser);
        assertEquals(0, userValidation.getExceptions().size());
    }

}