package com.turkcell.libraryapp.dto.bookReservation.request;

import java.util.Date;

public class UpdateBookReservationRequest {
    private Integer id;
    private Date reservationDate;

    public UpdateBookReservationRequest() {
    }

    public UpdateBookReservationRequest(Integer id, Date reservationDate) {
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
