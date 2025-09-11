package com.turkcell.libraryapp.dto.bookReservation.response;

import java.util.Date;

public class GetByIdBookResevationResponse {
    private Date reservationDate;

    public GetByIdBookResevationResponse() {
    }

    public GetByIdBookResevationResponse(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}
