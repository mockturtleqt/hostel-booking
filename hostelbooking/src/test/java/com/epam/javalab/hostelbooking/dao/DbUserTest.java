package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.config.HostelBookingConfiguration;
import com.epam.javalab.hostelbooking.domain.User;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= HostelBookingConfiguration.class, loader=AnnotationConfigContextLoader.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class DbUserTest {

    @Autowired
    private UserDao userDao;

    @Test
    @DatabaseSetup("classpath:users.xml")
    public void testFind() throws Exception {
        User user = userDao.findUserByLoginAndPassword("galia", "galia");
        assertEquals(151, user.getId());
    }
}
