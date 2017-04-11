package com.epam.javalab.hostelbooking.domain;

import java.time.LocalDate;

public class Booking extends Entity {
    private int id;
    private int guestId;
    private int placeId;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Booking() {

    }

    public int getId() {
        return id;
    }

    public void setId(int bookingId) {
        this.id = bookingId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int bookingGuestId) {
        this.guestId = bookingGuestId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int bookingPlaceId) {
        this.placeId = bookingPlaceId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != booking.id) return false;
        if (guestId != booking.guestId) return false;
        if (placeId != booking.placeId) return false;
        if (!checkIn.equals(booking.checkIn)) return false;
        return checkOut.equals(booking.checkOut);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + guestId;
        result = 31 * result + placeId;
        result = 31 * result + checkIn.hashCode();
        result = 31 * result + checkOut.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + id +
                ", bookingGuestId=" + guestId +
                ", bookingPlaceId=" + placeId +
                ", chechIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }


}
