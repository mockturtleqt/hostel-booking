package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.domain.Place;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceImplTest {
    @Mock
    private PlaceDao placeDao;

    @InjectMocks
    private PlaceServiceImpl placeService;

    private List<Place> appartments = new ArrayList<>();
    private Place placeMinsk;
    private Place placeGrodno;

    @Before
    public void setUp() throws Exception {
        placeMinsk = new Place();
        placeMinsk.setId(1);
        placeMinsk.setCity("Minsk");
        placeMinsk.setMaxPeople(4);
        appartments.add(placeMinsk);

        placeGrodno = new Place();
        placeGrodno.setId(2);
        placeGrodno.setCity("Grodno");
        placeGrodno.setMaxPeople(1);
        appartments.add(placeGrodno);

    }

    @Test
    public void findAll() throws Exception {
       when(placeDao.findAll()).thenReturn(appartments);
       List<Place> testAppartments = placeService.findAll();
       assertEquals(appartments, testAppartments);
    }

    @Test
    public void findPlaceByCity() throws Exception {
        when(placeDao.findPlaceByCity("Grodno")).thenReturn(placeGrodno);
        Place testPlace = placeService.findPlaceByCity("Grodno");
        assertEquals(testPlace.getId(), placeGrodno.getId());
    }

    @Test
    public void findPlaceByMaxPeople() throws Exception {
        when(placeDao.findPlaceByMaxPeopleCount(4)).thenReturn(placeMinsk);
        Place testPlace = placeService.findPlaceByMaxPeople(4);
        assertEquals(testPlace.getId(), placeMinsk.getId());
    }

}