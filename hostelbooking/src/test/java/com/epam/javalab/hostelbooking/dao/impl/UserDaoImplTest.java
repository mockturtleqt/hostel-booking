package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.config.TestConfiguration;
import com.epam.javalab.hostelbooking.dao.UserDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.User;
import com.epam.javalab.hostelbooking.domain.type.GenderType;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UserDaoImplTest {
    private static final String DROP_PLACE_SEQUENCE = "DROP SEQUENCE place_seq";
    private static final String DROP_BOOKING_SEQUENCE = "DROP SEQUENCE booking_seq";
    private static final String DROP_USER_SEQUENCE = "DROP SEQUENCE users_seq";
    private static final String CREATE_USER_SEQUENCE = "CREATE SEQUENCE users_seq START WITH 1";
    private static final String CREATE_BOOKING_SEQUENCE = "CREATE SEQUENCE booking_seq START WITH 1";
    private static final String CREATE_PLACE_SEQUENCE = "CREATE SEQUENCE place_seq START WITH 1";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    private User user = new User();

    @Before
    public void setUp() {
        user.setId(2);
        user.setFirstName("Nikita");
        user.setLastName("Sterlus");
        user.setEmail("nikita");
        user.setPassword("Nikitushka123");
        user.setGender(GenderType.MALE);
        user.setAge(20);
        user.setCardNumber(3561);
        user.setLogin("nikita");

        jdbcTemplate.execute(DROP_BOOKING_SEQUENCE);
        jdbcTemplate.execute(DROP_PLACE_SEQUENCE);
        jdbcTemplate.execute(DROP_USER_SEQUENCE);

        jdbcTemplate.execute(CREATE_BOOKING_SEQUENCE);
        jdbcTemplate.execute(CREATE_PLACE_SEQUENCE);
        jdbcTemplate.execute(CREATE_USER_SEQUENCE);
    }

    @Test
    @DatabaseSetup("classpath:beforeUserInsert.xml")
    @Ignore
    @ExpectedDatabase(value = "classpath:afterUserInsert.xml", table = "users", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addUser_ValidCredentialsGiven_ShouldCreateUser() throws DaoException {
        userDao.add(user);
    }

    @Test
    @DatabaseSetup("classpath:userDataSet.xml")
    public void findById_ExistingIdGiven_ShouldReturnUser() throws DaoException {
        User user = userDao.findById(11);
        assertEquals(user.getFirstName(), "Galia");
    }

    @Test(expected = DaoException.class)
    @DatabaseSetup("classpath:userDataSet.xml")
    public void findById_NonExistingIdGiven_ShouldThrowDaoException() throws DaoException {
        User user = userDao.findById(-11);
    }

    @Test
    @DatabaseSetup("classpath:userDataSet.xml")
    public void findByLoginAndPassword_ExistingCredentialsGiven_ShouldReturnUser() throws DaoException {
        User user = userDao.findByLoginAndPassword("galia", "galia");
        assertEquals("Galia", user.getFirstName());
    }

    @Test(expected = DaoException.class)
    @DatabaseSetup("classpath:userDataSet.xml")
    public void findByLoginAndPassword_NonExistingCredentialsGiven_ShouldThrowDaoException() throws DaoException {
        User user = userDao.findByLoginAndPassword("barney", "stinson");
    }

    @Test
    @DatabaseSetup("classpath:userDataSet.xml")
    public void findAll_ShouldReturnUserList() throws DaoException {
        List<User> userList = userDao.findAll();
        assertEquals(userList.size(), 11);
    }

    @Test
    @DatabaseSetup("classpath:beforeUserUpdate.xml")
    @Ignore
    @ExpectedDatabase(value = "classpath:afterUserUpdate.xml", table = "users", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void update_UpdatedProfileGiven_ShouldUpdateUser() throws DaoException {
        user.setAge(21);
        userDao.update(user);
    }

}