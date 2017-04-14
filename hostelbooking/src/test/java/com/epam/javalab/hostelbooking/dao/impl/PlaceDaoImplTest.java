package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.config.HostelBookingConfiguration;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= HostelBookingConfiguration.class, loader=AnnotationConfigContextLoader.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class PlaceDaoImplTest {
    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void findPlaceById() throws Exception {

    }

    @Test
    public void findPlaceByCity() throws Exception {

    }

    @Test
    public void findPlaceByMaxPeopleCount() throws Exception {

    }

}