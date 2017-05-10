package com.epam.javalab.hostelbooking.service;

import com.epam.javalab.hostelbooking.domain.Place;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;

import java.util.List;

public interface PlaceService extends EntityService<Place> {

    List<Place> findByCity(String city) throws ServiceException;

    List<Place> findByMaxPeople(int maxPeopleCount) throws ServiceException;
}
