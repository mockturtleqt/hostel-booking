package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.Place;

import java.util.List;

public interface PlaceDao extends EntityDao<Place> {

    List<Place> findByCity(String city) throws DaoException;

    List<Place> findByMaxPeopleCount(int maxPeopleCount) throws DaoException;
}
