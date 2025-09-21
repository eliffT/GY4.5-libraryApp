package com.turkcell.libraryapp.dto.bookReservation.response;

import com.turkcell.libraryapp.dto.book.response.BookResponse;
import com.turkcell.libraryapp.dto.user.response.UserResponse;

import java.time.LocalDate;


public class UpdatedReservationResponse {

    private UserResponse user;
    private BookResponse book;
    private LocalDate reservationDate;


    public UpdatedReservationResponse() {
    }

    public UpdatedReservationResponse(LocalDate reservationDate,  UserResponse user, BookResponse book) {
        this.reservationDate = reservationDate;
        this.user = user;
        this.book = book;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public BookResponse getBook() {
        return book;
    }

    public void setBook(BookResponse book) {
        this.book = book;
    }
}
