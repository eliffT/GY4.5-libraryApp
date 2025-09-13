package com.turkcell.libraryapp.dto.loan.request;

import com.turkcell.libraryapp.entity.enumarations.LoanStatus;
import java.util.Date;

public class LoanRequest {

    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private LoanStatus status;
    private Integer userId;
    private Integer bookId;

    public LoanRequest() {
    }

    public LoanRequest(Date borrowDate, Date dueDate, Date returnDate, LoanStatus status, Integer userId, Integer bookId) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.userId = userId;
        this.bookId = bookId;
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
