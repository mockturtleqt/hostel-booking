package com.epam.javalab.hostelbooking.service;

import com.epam.javalab.hostelbooking.domain.Place;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;

import java.util.List;

public interface PlaceService {
    List<Place> findAll() throws ServiceException;

    List<Place> findPlaceByCity(String city) throws ServiceException;

    List<Place> findPlaceByMaxPeople(int maxPeopleCount) throws ServiceException;
}
