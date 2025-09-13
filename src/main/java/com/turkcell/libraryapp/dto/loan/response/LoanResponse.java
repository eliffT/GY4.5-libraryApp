package com.turkcell.libraryapp.dto.loan.response;

import com.turkcell.libraryapp.dto.book.BookForGetDto;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.enumarations.LoanStatus;
import java.util.Date;

public class LoanResponse {

    private Integer id;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private LoanStatus status;
    private UserResponse user;
    private BookForGetDto book;

    public LoanResponse() {
    }

    public LoanResponse(Integer id, Date borrowDate, Date dueDate, Date returnDate, LoanStatus status, UserResponse user, BookForGetDto book) {
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

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
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

    public BookForGetDto getBook() {
        return book;
    }

    public void setBook(BookForGetDto book) {
        this.book = book;
    }
}
