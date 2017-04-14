package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookingDao")
public class BookingDaoImpl implements BookingDao {

    private JdbcTemplate jdbcTemplate;

    public BookingDaoImpl() {
    }

    @Autowired
    public BookingDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
