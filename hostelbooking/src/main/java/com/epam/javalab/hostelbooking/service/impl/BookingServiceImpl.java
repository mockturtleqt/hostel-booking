package com.epam.javalab.hostelbooking.service.impl;

import com.epam.javalab.hostelbooking.dao.BookingDao;
import com.epam.javalab.hostelbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
    private BookingDao bookingDao;

    public BookingServiceImpl() {

    }

    @Autowired
    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }
}
