package com.turkcell.libraryapp.dto.bookReservation.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateReservationRequest {

    @NotNull
    private LocalDate reservationDate;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer bookId;

    public CreateReservationRequest() {
    }

    public CreateReservationRequest(LocalDate reservationDate, Integer userId, Integer bookId) {
        this.reservationDate = reservationDate;
        this.userId = userId;
        this.bookId = bookId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
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
