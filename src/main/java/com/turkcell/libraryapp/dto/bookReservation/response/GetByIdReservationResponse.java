package com.turkcell.libraryapp.dto.bookReservation.response;

import java.util.Date;

public class GetByIdReservationResponse {
    private Date reservationDate;

    public GetByIdReservationResponse() {
    }

    public GetByIdReservationResponse(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}
