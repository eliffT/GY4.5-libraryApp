package com.turkcell.libraryapp.dto.fine.response;

public class FineResponse {

    private Integer id;
    private Boolean isPaid;
    private Integer amount;
    private Integer loanId;

    public FineResponse() {
    }

    public FineResponse(Integer id, Boolean isPaid, Integer amount, Integer loanId) {
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

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
}
