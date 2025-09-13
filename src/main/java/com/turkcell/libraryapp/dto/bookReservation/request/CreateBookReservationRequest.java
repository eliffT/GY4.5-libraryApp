package com.turkcell.libraryapp.dto.bookReservation.request;

import java.util.Date;

public class CreateBookReservationRequest {
    private Date reservationDate;
    private Integer userId;
    private Integer bookId;

    public CreateBookReservationRequest() {
    }

    public CreateBookReservationRequest(Date reservationDate, Integer userId, Integer bookId) {
        this.reservationDate = reservationDate;
        this.userId = userId;
        this.bookId = bookId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
