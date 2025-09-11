package com.turkcell.libraryapp.dto.bookReservation.request;

import java.util.Date;

public class CreateBookReservationRequest {
    private Date reservationDate;

    public CreateBookReservationRequest() {
    }

    public CreateBookReservationRequest(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}
