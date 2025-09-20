package com.turkcell.libraryapp.dto.loan.response;

import com.turkcell.libraryapp.dto.book.response.BookResponse;
import com.turkcell.libraryapp.dto.fine.response.FineResponse;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.enumList.LoanStatus;

import java.time.LocalDate;
import java.util.List;

public class LoanResponse {

    private Integer id;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus status;
    private UserResponse user;
    private BookResponse book;

    public LoanResponse() {
    }

    public LoanResponse(Integer id, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, LoanStatus status,
                        UserResponse user, BookResponse book) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.user = user;
        this.book = book;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
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
