package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookingDao")
public class BookingDaoImpl implements BookingDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void getBook() {

    }
}
