package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.PlaceDao;
import com.epam.javalab.hostelbooking.domain.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("placeDao")
public class PlaceDaoImpl implements PlaceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Place> findAll() {

        return null;
    }
}
