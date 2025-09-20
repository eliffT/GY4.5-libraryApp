package com.turkcell.libraryapp.dto.fine.response;

public class FineResponse {

    private Integer id;
    private boolean isPaid;
    private double amount;
    private Integer loanId;

    public FineResponse() {
    }

    public FineResponse(Integer id, boolean isPaid, double amount, Integer loanId) {
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
}
