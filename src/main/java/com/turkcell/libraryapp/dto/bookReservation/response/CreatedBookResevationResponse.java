package com.turkcell.libraryapp.dto.bookReservation.response;

import java.util.Date;

public class CreatedBookResevationResponse {
    private Integer id;
    private Date reservationDate;

    public CreatedBookResevationResponse() {
    }

    public CreatedBookResevationResponse(Integer id, Date reservationDate) {
        this.id = id;
        this.reservationDate = reservationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}
