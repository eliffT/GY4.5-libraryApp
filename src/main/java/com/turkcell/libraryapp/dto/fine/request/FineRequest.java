package com.turkcell.libraryapp.dto.fine.request;

public class FineRequest {

    private Boolean isPaid;
    private Integer amount;
    private Integer loanId;

    public FineRequest() {
    }

    public FineRequest(Boolean isPaid, Integer amount, Integer loanId) {
        this.isPaid = isPaid;
        this.amount = amount;
        this.loanId = loanId;
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
