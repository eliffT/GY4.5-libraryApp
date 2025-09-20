package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.loan.request.LoanRequest;
import com.turkcell.libraryapp.dto.loan.request.LoanReturnRequest;
import com.turkcell.libraryapp.dto.loan.response.LoanResponse;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.entity.enumarations.LoanStatus;
import com.turkcell.libraryapp.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponse createLoan(@Valid @RequestBody LoanRequest request) {
        return loanService.createLoan(request);
    }

    @PostMapping("/return")
    public LoanResponse returnLoan(@Valid @RequestBody LoanReturnRequest request) {
        return loanService.returnLoan(request);
    }

    @GetMapping("/members/{id}")
    public List<LoanResponse> getLoansByUserIdAndStatus(@PathVariable Integer id, @RequestParam String status) {
        return loanService.getLoansByUserIdAndStatusIn(id, status);
    }

    @GetMapping //+
    public List<LoanResponse> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")//+
    public LoanResponse getById(@PathVariable Integer id) {
        return loanService.getLoanById(id);
    }

    @PutMapping("/{id}")
    public LoanResponse update(@PathVariable Integer id, @Valid @RequestBody LoanRequest request) {
        return loanService.updateLoan(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        loanService.deleteLoan(id);
    }
}
