package com.epam.javalab.hostelbooking.dao.mapper;

import com.epam.javalab.hostelbooking.domain.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class BookingMapper implements RowMapper<Booking> {
    private static final String BOOKING_ID = "booking_id";
    private static final String BOOKING_GUEST_ID = "booking_guest_id";
    private static final String BOOKING_PLACE_ID = "booking_place_id";
    private static final String BOOKING_CHECK_IN = "booking_check_out";
    private static final String BOOKING_CHECK_OUT = "booking_check_in";

    @Override
    public Booking mapRow(ResultSet resultSet, int i) throws SQLException {
        Booking booking = new Booking();

        booking.setId(resultSet.getInt(BOOKING_ID));
        booking.setGuestId(resultSet.getInt(BOOKING_GUEST_ID));
        booking.setPlaceId(resultSet.getInt(BOOKING_PLACE_ID));
        booking.setCheckIn(resultSet.getDate(BOOKING_CHECK_IN).toLocalDate());
        booking.setCheckOut(resultSet.getDate(BOOKING_CHECK_OUT).toLocalDate());

        return booking;
    }
}
