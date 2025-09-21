package com.turkcell.libraryapp.dto.loan;

public class TotalLoanDto {
    private Integer totalLoan;

    public TotalLoanDto(Integer totalLoan) {
        this.totalLoan = totalLoan;
    }

    public TotalLoanDto() {
    }

    public Integer getTotalLoan() {
        return totalLoan;
    }
    public void setTotalLoan(Integer totalLoan) {
        this.totalLoan = totalLoan;
    }
}
