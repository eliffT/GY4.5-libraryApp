package com.turkcell.libraryapp.dto.fine;

public class FineForAddDto {
    private Boolean isPaid;
    private Integer amount;

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
