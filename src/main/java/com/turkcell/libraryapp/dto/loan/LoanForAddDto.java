// src/main/java/com/turkcell/libraryapp/dto/loan/LoanForAddDto.java
package com.turkcell.libraryapp.dto.loan;

import java.util.Date;

public class LoanForAddDto {
    private Date borrowDate;
    private Date returnDate;
    private Boolean delivered;
    private Integer userId;
    private Integer bookId;
    private Integer statusId;

    public LoanForAddDto(Date borrowDate, Date returnDate, Boolean delivered, Integer userId, Integer bookId, Integer statusId) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.delivered = delivered;
        this.userId = userId;
        this.bookId = bookId;
        this.statusId = statusId;
    }

    public LoanForAddDto() {
    }

    public Date getBorrowDate() { return borrowDate; }

    public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate; }

    public Date getReturnDate() { return returnDate; }

    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    public Boolean getDelivered() { return delivered; }

    public void setDelivered(Boolean delivered) { this.delivered = delivered; }

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

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
