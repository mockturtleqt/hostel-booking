package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.config.HostelBookingConfiguration;
import com.epam.javalab.hostelbooking.config.TestConfiguration;
import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.domain.Place;
import com.epam.javalab.hostelbooking.service.impl.PlaceServiceImpl;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class PlaceDaoImplTest {
    @Autowired
    private PlaceDao placeDao;

    @Test
    @DatabaseSetup("classpath:placeDataSet.xml")
    public void findAll() throws Exception {
        List<Place> places = placeDao.findAll();
        assertEquals(places.size(), 5);
    }

    @Test
    @DatabaseSetup("classpath:placeDataSet.xml")
    public void findPlaceById() throws Exception {
        Place place = placeDao.findPlaceById(266);
        assertEquals(place.getCity(), "Palekastro");
    }

    @Test
    @DatabaseSetup("classpath:placeDataSet.xml")
    public void findPlaceByCity() throws Exception {
        List<Place> places = placeDao.findPlaceByCity("Paris");
        assertEquals(places.size(), 1);
    }

    @Test
    @DatabaseSetup("classpath:placeDataSet.xml")
    public void findPlaceByMaxPeopleCount() throws Exception {
        List<Place> places = placeDao.findPlaceByMaxPeopleCount(4);
        assertEquals(places.get(0).getId(), 266);
    }

}