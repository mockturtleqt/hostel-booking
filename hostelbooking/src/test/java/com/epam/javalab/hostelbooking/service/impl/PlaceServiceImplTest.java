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
    private List<Place> grodnoApartments = new ArrayList<>();
    private List<Place> minskApartments = new ArrayList<>();

    private Place placeMinsk;
    private Place placeGrodno;

    @Before
    public void setUp() throws Exception {
        placeMinsk = new Place();
        placeMinsk.setId(1);
        placeMinsk.setCity("Minsk");
        placeMinsk.setMaxPeople(4);
        appartments.add(placeMinsk);
        minskApartments.add(placeMinsk);

        placeGrodno = new Place();
        placeGrodno.setId(2);
        placeGrodno.setCity("Grodno");
        placeGrodno.setMaxPeople(1);
        appartments.add(placeGrodno);
        grodnoApartments.add(placeGrodno);

    }

    @Test
    public void findAll() throws Exception {
       when(placeDao.findAll()).thenReturn(appartments);
       List<Place> testAppartments = placeService.findAll();
       assertEquals(appartments, testAppartments);
    }

    @Test
    public void findPlaceByCity() throws Exception {
        when(placeDao.findPlaceByCity("Grodno")).thenReturn(grodnoApartments);
        Place testPlace = placeService.findPlaceByCity("Grodno").get(0);
        assertEquals(testPlace.getId(), placeGrodno.getId());
    }

    @Test
    public void findPlaceByMaxPeople() throws Exception {
        when(placeDao.findPlaceByMaxPeopleCount(4)).thenReturn(minskApartments);
        Place testPlace = placeService.findPlaceByMaxPeople(4).get(0);
        assertEquals(testPlace.getId(), placeMinsk.getId());
    }

}