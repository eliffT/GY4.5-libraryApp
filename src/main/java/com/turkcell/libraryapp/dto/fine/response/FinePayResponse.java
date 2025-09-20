package com.turkcell.libraryapp.dto.fine.response;

import java.time.LocalDate;

public class FinePayResponse {

    private Integer id;
    private boolean isPaid;
    private double amount;
    private LocalDate paymentDate;
    private Integer loanId;

    public FinePayResponse() {
    }

    public FinePayResponse(Integer id, boolean isPaid, double amount, Integer loanId) {
        this.id = id;
        this.isPaid = isPaid;
        this.amount = amount;
        this.loanId = loanId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
