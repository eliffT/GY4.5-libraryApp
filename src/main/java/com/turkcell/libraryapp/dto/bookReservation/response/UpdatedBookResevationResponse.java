package com.turkcell.libraryapp.dto.bookReservation.response;

import java.util.Date;

public class UpdatedBookResevationResponse {
    private Date reservationDate;

    public UpdatedBookResevationResponse() {
    }

    public UpdatedBookResevationResponse(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}
