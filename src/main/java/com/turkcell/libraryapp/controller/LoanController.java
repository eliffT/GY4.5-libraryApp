package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.loan.request.LoanRequest;
import com.turkcell.libraryapp.dto.loan.response.LoanResponse;
import com.turkcell.libraryapp.service.LoanService;
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
    public LoanResponse add(@RequestBody LoanRequest request) {
        return loanService.addWithDto(request);
    }

    @GetMapping //+
    public List<LoanResponse> getAll() {
        return loanService.getAllWithDto();
    }

    @GetMapping("/{id}")//+
    public LoanResponse getById(@PathVariable Integer id) {
        return loanService.getByIdWithDto(id);
    }

    @PutMapping("/{id}")
    public LoanResponse update(@PathVariable Integer id, @RequestBody LoanRequest request) {
        return loanService.updateWithDto(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        loanService.deleteById(id);
    }
}
