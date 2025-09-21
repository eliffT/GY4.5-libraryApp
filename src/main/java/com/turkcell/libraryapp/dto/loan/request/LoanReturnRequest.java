package com.turkcell.libraryapp.dto.loan.request;

import jakarta.validation.constraints.NotNull;

public class LoanReturnRequest {

    @NotNull
    private Integer id;

    public LoanReturnRequest(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}