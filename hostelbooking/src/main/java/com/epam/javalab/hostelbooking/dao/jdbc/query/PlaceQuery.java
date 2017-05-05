package com.epam.javalab.hostelbooking.dao.jdbc.query;

public class PlaceQuery {
    public static final String SQL_FIND_ALL_APARTMENTS = "SELECT place_id, place_owner_id, place_name, " +
            "place_max_people, place_description, place_cost, place_country, place_city, place_street FROM place";

    public static final String SQL_FIND_APARTMENT_BY_ID = "SELECT place_id, place_owner_id, place_name, place_max_people, " +
            "place_description, place_cost, place_country, place_city, place_street FROM place WHERE place_id = ?";


    public static final String SQL_FIND_APARTMENT_BY_CITY = "SELECT place_id, place_owner_id, place_name, place_max_people, " +
            "place_description, place_cost, place_country, place_city, place_street FROM place WHERE place_city = ?";

    public static final String SQL_FIND_APARTMANT_BY_MAX_PEOPLE_COUNT = "SELECT place_id, place_owner_id, place_name, " +
            "place_max_people, place_description, place_cost, place_country, place_city, place_street FROM place " +
            "WHERE place_max_people >= ? ORDER BY place_max_people";
}
