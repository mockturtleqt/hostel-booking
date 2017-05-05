package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.config.TestConfiguration;
import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.Place;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
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
public class PlaceDaoImplTest {
    private static final String DROP_PLACE_SEQUENCE = "DROP SEQUENCE place_seq";
    private static final String DROP_BOOKING_SEQUENCE = "DROP SEQUENCE booking_seq";
    private static final String DROP_USER_SEQUENCE = "DROP SEQUENCE users_seq";
    private static final String CREATE_USER_SEQUENCE = "CREATE SEQUENCE users_seq START WITH 1";
    private static final String CREATE_BOOKING_SEQUENCE = "CREATE SEQUENCE booking_seq START WITH 1";
    private static final String CREATE_PLACE_SEQUENCE = "CREATE SEQUENCE place_seq START WITH 1";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {
        jdbcTemplate.execute(DROP_BOOKING_SEQUENCE);
        jdbcTemplate.execute(DROP_PLACE_SEQUENCE);
        jdbcTemplate.execute(DROP_USER_SEQUENCE);

        jdbcTemplate.execute(CREATE_BOOKING_SEQUENCE);
        jdbcTemplate.execute(CREATE_PLACE_SEQUENCE);
        jdbcTemplate.execute(CREATE_USER_SEQUENCE);
    }

    @Autowired
    private PlaceDao placeDao;

    @Test
    @DatabaseSetup({"classpath:userDataSet.xml", "classpath:placeDataSet.xml"})
    public void findAll_ShouldReturnPlaceList() throws DaoException {
        List<Place> places = placeDao.findAll();
        assertEquals(places.size(), 5);
    }

    @Test
    @DatabaseSetup({"classpath:userDataSet.xml", "classpath:placeDataSet.xml"})
    public void findPlaceById_ExistingIdGiven_ShouldReturnPlace() throws DaoException {
        Place place = placeDao.findPlaceById(1);
        assertEquals("Palekastro", place.getCity());
    }

    @Test(expected = DaoException.class)
    @DatabaseSetup({"classpath:userDataSet.xml", "classpath:placeDataSet.xml"})
    public void findPlaceById_NonExistingIdGiven_ShouldThrowDaoException() throws DaoException {
        Place place = placeDao.findPlaceById(-3);
    }

    @Test
    @DatabaseSetup({"classpath:userDataSet.xml", "classpath:placeDataSet.xml"})
    public void findPlaceByCity_ExistingCityGiven_ShouldReturnPlaceList() throws DaoException {
        List<Place> places = placeDao.findPlaceByCity("Palekastro");
        assertEquals(1, places.size());
    }

    @Test(expected = DaoException.class)
    @DatabaseSetup({"classpath:userDataSet.xml", "classpath:placeDataSet.xml"})
    public void findPlaceByCity_NonExistingCityGiven_ShouldThrowDaoException() throws DaoException {
        placeDao.findPlaceByCity("Lalaland");
    }

    @Test
    @DatabaseSetup({"classpath:userDataSet.xml", "classpath:placeDataSet.xml"})
    public void findPlaceByMaxPeopleCount_ExistingCapacityGiven_ShouldReturnPlaceList() throws DaoException {
        List<Place> places = placeDao.findPlaceByMaxPeopleCount(4);
        assertEquals(4, places.size());
    }

    @Test(expected = DaoException.class)
    @DatabaseSetup({"classpath:userDataSet.xml", "classpath:placeDataSet.xml"})
    public void findPlaceByMaxPeopleCount_NonExistingCapacityGiven_ShouldThrowDaoException() throws DaoException {
        placeDao.findPlaceByMaxPeopleCount(120);
    }

}