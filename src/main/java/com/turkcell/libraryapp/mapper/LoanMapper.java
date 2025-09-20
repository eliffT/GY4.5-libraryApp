package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.loan.request.LoanRequest;
import com.turkcell.libraryapp.dto.loan.request.LoanReturnRequest;
import com.turkcell.libraryapp.dto.loan.response.LoanResponse;
import com.turkcell.libraryapp.entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {UserMapper.class, BookMapper.class})
public interface LoanMapper {


    LoanResponse loanToLoanResponse(Loan loan);
    Loan loanReturnRequestToLoan(LoanReturnRequest loanReturnRequest);
    List<LoanResponse> loanToLoanResponsesList(List<Loan> loans);
    Loan LoanRequestToLoan(LoanRequest loanRequest);
}
