package com.turkcell.libraryapp.dto.bookReservation.request;

import com.turkcell.libraryapp.dto.book.request.BookRequest;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class UpdateReservationRequest {
    @NotNull
    private Integer id;
    private LocalDate reservationDate;
    @NotNull
    private Integer bookId;

    public UpdateReservationRequest() {
    }

    public UpdateReservationRequest(Integer id, LocalDate reservationDate,  Integer bookId) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.bookId = bookId;
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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
