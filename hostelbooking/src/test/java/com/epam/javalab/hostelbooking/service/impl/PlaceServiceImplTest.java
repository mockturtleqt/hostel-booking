package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.Place;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceImplTest {
    @Mock
    private PlaceDao placeDao;

    @InjectMocks
    private PlaceServiceImpl placeService;

    private List<Place> apartments = new ArrayList<>();
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
        minskApartments.add(placeMinsk);

        placeGrodno = new Place();
        placeGrodno.setId(2);
        placeGrodno.setCity("Grodno");
        placeGrodno.setMaxPeople(1);
        grodnoApartments.add(placeGrodno);

        apartments.add(placeMinsk);
        apartments.add(placeGrodno);

    }

    @Test
    public void findAll_ShouldReturnPlaceList() throws Exception {
        when(placeDao.findAll()).thenReturn(apartments);
        List<Place> testApartments = placeService.findAll();
        assertEquals(apartments, testApartments);
    }

    @Test
    public void findPlaceByCity_ExistingCityGiven_ShouldReturnPlaceList() throws Exception {
        when(placeDao.findPlaceByCity("Grodno")).thenReturn(grodnoApartments);
        List<Place> testPlaceList = placeService.findPlaceByCity("Grodno");
        assertEquals(grodnoApartments, testPlaceList);
    }

    @Test(expected = ServiceException.class)
    public void findPlaceByCity_NonExistingCityGiven_ShouldThrowServiceException() throws Exception {
        when(placeDao.findPlaceByCity("Lalaland")).thenThrow(DaoException.class);
        placeService.findPlaceByCity("Lalaland");
    }

    @Test
    public void findPlaceByMaxPeopleCount_ExistingCapacityGiven_ShouldReturnPlaceList() throws Exception {
        when(placeDao.findPlaceByMaxPeopleCount(4)).thenReturn(minskApartments);
        List<Place> testPlaceList = placeService.findPlaceByMaxPeople(4);
        assertEquals(minskApartments, testPlaceList);
    }

    @Test(expected = ServiceException.class)
    public void findPlaceByMaxPeopleCount_NonExistingCapacityGiven_ShouldThrowServiceException() throws Exception {
        when(placeDao.findPlaceByMaxPeopleCount(400)).thenThrow(DaoException.class);
        placeService.findPlaceByMaxPeople(400);
    }

}