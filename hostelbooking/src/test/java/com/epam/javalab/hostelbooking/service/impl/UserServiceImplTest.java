package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private User updatedUser;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1);
        user.setFirstName("Galia");
        user.setLastName("Semashka");
        user.setLogin("mockturtlee");
        user.setPassword("123Mockturtle");
        user.setEmail("galia.semashko@mail.com");

        updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setFirstName("123");
        updatedUser.setLastName("Semashka");
        updatedUser.setLogin("mockturtlee");
        updatedUser.setPassword("Mockturtle123");
        updatedUser.setEmail("galia.semashko@mail.com");
        updatedUser.setCardNumber(1234567);

    }

    @Test
    public void createUser_ValidUserGiven_ShouldReturnCreatedUser() throws Exception {
        when(userDao.add(user)).thenReturn(user);
        User testUser = userService.add(user);
        assertEquals(user.getId(), testUser.getId());
    }

    @Test
    public void findUserByLoginAndPassword_ValidCredentialsGiven_ShouldReturnUser() throws Exception {
        when(userDao.findByLoginAndPassword(user.getLogin(), user.getPassword())).thenReturn(user);
        User testUser = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
        assertEquals(user.getId(), testUser.getId());
    }

    @Test(expected = ServiceException.class)
    public void findUserByLoginAndPassword_InvalidCredentialsGiven_ShouldThrowServiceException() throws Exception {
        when(userDao.findByLoginAndPassword(user.getLogin(), user.getPassword())).thenThrow(ServiceException.class);
        userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    @Test
    public void changeUserPassword_ValidCredentialsGiven_ShouldChangePassword() throws Exception {
        when(userDao.findById(user.getId())).thenReturn(user);
        when(userDao.update(updatedUser)).thenReturn(updatedUser);
        User testUser = userService.changePassword(user.getId(), "Mockturtle123");
        assertEquals(user.getPassword(), testUser.getPassword());
    }

    @Test
    public void resetUserPassword_ValidCredentialsGiven_ShouldResetPassword() throws Exception {
        when(userDao.findById(user.getId())).thenReturn(user);
        when(userDao.update(user)).thenReturn(user);
        when(userDao.update(updatedUser)).thenReturn(updatedUser);
        String resetKey = userService.generateResetKey(user.getId(), user.getLogin(), user.getEmail());
        user.setResetKey(resetKey);

        boolean success = userService.resetPassword(user.getId(), user.getResetKey(), "Mockturtle123");
        assertTrue(success);
    }

    @Test
    public void updateUserProfile_ValidCredentialsGiven_ShouldUpdateProfile() throws Exception {
        when(userDao.update(user)).thenReturn(user);
        User updatedUSer = userService.update(user);
        assertEquals("Galia", updatedUSer.getFirstName());
        verify(userDao).update(user);
    }

}