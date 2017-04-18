package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
    public void createUser() throws Exception {
        when(userDao.createUser(user)).thenReturn(user);
        User testUser = userService.createUser(user);
        assertEquals(testUser.getId(), user.getId());
    }

    @Test
    public void findUserByLoginAndPassword() throws Exception {
        when(userDao.findUserByLoginAndPassword(user.getLogin(), user.getPassword())).thenReturn(user);
        User testUser = userService.findUserByLoginAndPassword(user.getLogin(), user.getPassword());
        assertEquals(testUser.getId(), user.getId());
    }

    @Test
    public void changeUserPassword() throws Exception {
        when(userDao.findUserById(user.getId())).thenReturn(user);
        when(userDao.updateUserProfile(updatedUser)).thenReturn(updatedUser);
        User testUser = userService.changeUserPassword(user.getId(), "Mockturtle123");
        assertEquals(testUser.getPassword(), user.getPassword());
    }

    @Test
    public void resetUserPassword() throws Exception {
        when(userDao.findUserById(user.getId())).thenReturn(user);
        when(userDao.updateUserProfile(user)).thenReturn(user);
        when(userDao.updateUserProfile(updatedUser)).thenReturn(updatedUser);
        String resetKey = userService.generateResetKey(user.getId(), user.getLogin(), user.getEmail());
        user.setResetKey(resetKey);

        boolean success = userService.resetUserPassword(user.getId(), user.getResetKey(), "Mockturtle123");
        assertTrue(success);
    }

    @Test
    public void updateUserProfile() throws Exception {
        when(userDao.updateUserProfile(user)).thenReturn(user);
        User updatedUSer = userService.updateUserProfile(user);
        assertEquals(updatedUSer.getFirstName(), "Galia");
        verify(userDao).updateUserProfile(user);
    }

}