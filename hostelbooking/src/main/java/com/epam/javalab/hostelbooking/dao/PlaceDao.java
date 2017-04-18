package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.Place;

import java.util.List;

public interface PlaceDao {
    List<Place> findAll() throws DaoException;

    Place findPlaceById(int id) throws DaoException;

    List<Place> findPlaceByCity(String city) throws DaoException;

    List<Place> findPlaceByMaxPeopleCount(int maxPeopleCount) throws DaoException;
}
