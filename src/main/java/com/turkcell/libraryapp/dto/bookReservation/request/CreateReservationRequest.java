package com.turkcell.libraryapp.dto.bookReservation.request;

import com.turkcell.libraryapp.entity.enumList.BookStatus;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateReservationRequest {

    @NotNull
    private LocalDate reservationDate;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer bookId;
    private BookStatus status;

    public CreateReservationRequest() {
    }

    public CreateReservationRequest(LocalDate reservationDate, Integer userId, Integer bookId, BookStatus status) {
        this.reservationDate = reservationDate;
        this.userId = userId;
        this.bookId = bookId;
        this.status = status;
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

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
