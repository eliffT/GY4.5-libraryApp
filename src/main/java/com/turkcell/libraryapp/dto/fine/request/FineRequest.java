package com.turkcell.libraryapp.dto.fine.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class FineRequest {

    @NotNull
    private boolean isPaid;
    @PositiveOrZero
    private double amount;
    @NotNull
    private Integer loanId;

    public FineRequest() {
    }

    public FineRequest(boolean isPaid, double amount, Integer loanId) {
        this.isPaid = isPaid;
        this.amount = amount;
        this.loanId = loanId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
}
