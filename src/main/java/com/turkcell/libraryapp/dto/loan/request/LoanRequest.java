package com.turkcell.libraryapp.dto.loan.request;

import jakarta.validation.constraints.NotNull;

public class LoanRequest {

    @NotNull
    private Integer userId;
    @NotNull
    private Integer bookId;

    public LoanRequest() {
    }

    public LoanRequest(Integer userId, Integer bookId) {
        this.userId = userId;
        this.bookId = bookId;
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
