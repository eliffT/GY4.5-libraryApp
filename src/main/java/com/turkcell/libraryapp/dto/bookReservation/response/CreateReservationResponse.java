package com.turkcell.libraryapp.dto.bookReservation.response;

import java.time.LocalDate;

public class CreateReservationResponse {
    private Integer id;
    private LocalDate reservationDate;

    public CreateReservationResponse() {
    }

    public CreateReservationResponse(Integer id, LocalDate reservationDate) {
        this.id = id;
        this.reservationDate = reservationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
}
