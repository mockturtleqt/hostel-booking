package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.domain.Place;

import java.util.List;

public interface PlaceDao {
    List<Place> findAll();
}
