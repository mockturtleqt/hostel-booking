package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.Place;
import com.epam.javalab.hostelbooking.service.PlaceService;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService {
    private PlaceDao placeDao;

    public PlaceServiceImpl() {

    }

    @Autowired
    public PlaceServiceImpl(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public Place add(Place place) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Place> findAll() throws ServiceException {
        try {
            return placeDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Cannot find a place ", e);
        }
    }

    @Override
    public Place update(Place place) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Place> findByCity(String city) throws ServiceException {
        try {
            return placeDao.findByCity(city);
        } catch (DaoException e) {
            throw new ServiceException("Cannot find a place ", e);
        }
    }

    @Override
    public List<Place> findByMaxPeople(int maxPeopleCount) throws ServiceException {
        try {
            return placeDao.findByMaxPeopleCount(maxPeopleCount);
        } catch (DaoException e) {
            throw new ServiceException("Cannot find a place ", e);
        }
    }
}
