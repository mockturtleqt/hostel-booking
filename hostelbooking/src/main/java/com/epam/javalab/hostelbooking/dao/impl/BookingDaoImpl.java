package com.epam.javalab.hostelbooking.dao.impl;

import com.epam.javalab.hostelbooking.dao.BookingDao;
import com.epam.javalab.hostelbooking.dao.exception.DaoException;
import com.epam.javalab.hostelbooking.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookingDao")
public class BookingDaoImpl implements BookingDao {

    private JdbcTemplate jdbcTemplate;

    public BookingDaoImpl() {
    }

    @Autowired
    public BookingDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Booking add(Booking booking) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Booking findById(int id) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Booking> findAll() throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Booking update(Booking booking) throws DaoException {
        throw new UnsupportedOperationException();
    }
}
