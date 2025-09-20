package com.turkcell.libraryapp.dto.bookReservation.response;

import com.turkcell.libraryapp.dto.book.response.BookResponse;
import com.turkcell.libraryapp.dto.user.response.UserResponse;

import java.time.LocalDate;
import java.util.Date;

public class GetAllReservationResponse {
    private Integer id;
    private LocalDate reservationDate;
    private UserResponse user;
    private BookResponse book;

    public GetAllReservationResponse() {
    }

    public GetAllReservationResponse(Integer id, LocalDate reservationDate,  UserResponse user, BookResponse book) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.user = user;
        this.book = book;
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

    public BookResponse getBook() {
        return book;
    }

    public void setBook(BookResponse book) {
        this.book = book;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
