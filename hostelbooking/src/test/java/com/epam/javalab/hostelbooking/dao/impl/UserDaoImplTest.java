package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.config.TestConfiguration;
import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.domain.type.GenderType;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    private User user = new User();

    @Before
    public void setUp() {
        user.setId(153);
        user.setFirstName("Nikita");
        user.setLastName("Sterlus");
        user.setEmail("nikita");
        user.setPassword("nikita");
        user.setGender(GenderType.MALE);
        user.setAge(20);
        user.setCardNumber(3561);
        user.setLogin("nikita");
    }

    @Test
    @DatabaseSetup("classpath:userDataSet.xml")
    @ExpectedDatabase("classpath:newUserDataSet.xml")
    public void createUser() throws Exception {
        userDao.createUser(user);
    }

    @Test
    @DatabaseSetup("classpath:userDataSet.xml")
    public void findUserById() throws Exception {
        User user = userDao.findUserById(152);
        assertEquals(user.getFirstName(), "Galia");
    }

    @Test
    @DatabaseSetup("classpath:users.xml")
    public void findUserByLoginAndPassword() throws Exception {
        User user = userDao.findUserByLoginAndPassword("galia", "galia");
        assertEquals(152, user.getId());
    }

    @Test
    @DatabaseSetup("classpath:userDataSet.xml")
    public void findAllUsers() throws Exception {
        List<User> userList = userDao.findAllUsers();
        assertEquals(userList.size(), 11);
    }

    @Test
    @DatabaseSetup("classpath:userDataSet.xml")
    @ExpectedDatabase("classpath:updatedUserDataSet.xml")
    public void updateUserProfile() throws Exception {
        user.setAge(21);
        userDao.updateUserProfile(user);
    }

}