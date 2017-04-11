package com.epam.javalab.hostelbooking.dao.mapper;


import com.epam.javalab.hostelbooking.domain.Place;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceMapper implements RowMapper<Place> {
    private static final String PLACE_ID = "place_id";
    private static final String PLACE_OWNER_ID = "place_owner_id";
    private static final String PLACE_NAME = "place_name";
    private static final String PLACE_MAX_PEOPLE = "place_max_people";
    private static final String PLACE_DESCRIPTION = "place_description";
    private static final String PLACE_COST = "place_cost";
    private static final String PLACE_COUNTRY = "place_country";
    private static final String PLACE_CITY = "place_city";
    private static final String PLACE_STREET = "place_street";

    @Override
    public Place mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Place place = new Place();

        place.setId(resultSet.getInt(PLACE_ID));
        place.setOwnerId(resultSet.getInt(PLACE_OWNER_ID));
        place.setName(resultSet.getString(PLACE_NAME));
        place.setMaxPeople(resultSet.getInt(PLACE_MAX_PEOPLE));
        place.setDescription(resultSet.getString(PLACE_DESCRIPTION));
        place.setCost(resultSet.getFloat(PLACE_COST));
        place.setCountry(resultSet.getString(PLACE_COUNTRY));
        place.setCity(resultSet.getString(PLACE_CITY));
        place.setStreet(resultSet.getString(PLACE_STREET));

        return place;
    }
}
