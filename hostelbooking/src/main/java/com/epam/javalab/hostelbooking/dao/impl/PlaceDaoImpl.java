package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.dao.mapper.PlaceMapper;
import com.epam.javalab.hostelbooking.domain.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        try {
            return jdbcTemplate.query(SQL_FIND_ALL_APARTMENTS, new PlaceMapper());
        } catch (DataAccessException e) {
            throw new DaoException("Cannot find place ", e);
        }
    }

    @Override
    public Place findPlaceById(int id) throws DaoException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_APARTMENT_BY_ID,
                    new Object[]{id}, new PlaceMapper());
        } catch (DataAccessException e) {
            throw new DaoException("Cannot find place ", e);
        }
    }

    @Override
    public Place findPlaceByCity(String city) throws DaoException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_APARTMENT_BY_CITY,
                    new Object[]{city}, new PlaceMapper());
        } catch (DataAccessException e) {
            throw new DaoException("Cannot find place ", e);
        }
    }

    @Override
    public Place findPlaceByMaxPeopleCount(int maxPeopleCount) throws DaoException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_APARTMANT_BY_MAX_PEOPLE_COUNT,
                    new Object[]{maxPeopleCount}, new PlaceMapper());
        } catch (DataAccessException e) {
            throw new DaoException("Cannot find place ", e);
        }
    }


}
