package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.BookingDao;
import com.epam.javalab.hostelbooking.domain.Booking;
import com.epam.javalab.hostelbooking.service.BookingService;
import com.epam.javalab.hostelbooking.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
    private BookingDao bookingDao;

    public BookingServiceImpl() {

    }

    @Autowired
    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public Booking add(Booking booking) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Booking> findAll() throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Booking update(Booking booking) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}
