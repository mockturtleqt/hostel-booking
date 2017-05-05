package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.dao.mapper.PlaceMapper;
import com.epam.javalab.hostelbooking.domain.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.epam.javalab.hostelbooking.dao.jdbc.query.PlaceQuery.*;

@Repository("placeDao")
public class PlaceDaoImpl implements PlaceDao {
    private JdbcTemplate jdbcTemplate;

    public PlaceDaoImpl() {
    }

    @Autowired
    public PlaceDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Place> findAll() throws DaoException {
        List<Place> places = jdbcTemplate.query(SQL_FIND_ALL_APARTMENTS, new PlaceMapper());
        if (!places.isEmpty()) {
            return places;
        } else {
            throw new DaoException("There are no apartments");
        }
    }

    @Override
    public Place findPlaceById(int id) throws DaoException {
        List<Place> places = jdbcTemplate.query(SQL_FIND_APARTMENT_BY_ID,
                new Object[]{id}, new PlaceMapper());
        if (!places.isEmpty()) {
            return places.get(0);
        } else {
            throw new DaoException("Cannot find this apartment ");
        }
    }

    @Override
    public List<Place> findPlaceByCity(String city) throws DaoException {
        List<Place> places = jdbcTemplate.query(SQL_FIND_APARTMENT_BY_CITY,
                new Object[]{city}, new PlaceMapper());
        if (!places.isEmpty()) {
            return places;
        } else {
            throw new DaoException("Cannot find an apartment in " + city);
        }
    }

    @Override
    public List<Place> findPlaceByMaxPeopleCount(int maxPeopleCount) throws DaoException {
        List<Place> places = jdbcTemplate.query(SQL_FIND_APARTMANT_BY_MAX_PEOPLE_COUNT,
                new Object[]{maxPeopleCount}, new PlaceMapper());
        if (!places.isEmpty()) {
            return places;
        } else {
            throw new DaoException("Cannot find an apartment for " + maxPeopleCount + " people");
        }
    }


}
