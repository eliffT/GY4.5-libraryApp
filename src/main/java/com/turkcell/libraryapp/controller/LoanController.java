// src/main/java/com/turkcell/libraryapp/controller/LoansController.java
package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.loan.LoanForAddDto;
import com.turkcell.libraryapp.dto.loan.LoanForGetDto;
import com.turkcell.libraryapp.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping // +
    public List<LoanForGetDto> getAll() {
        return loanService.getAllWithDto();
    }

    @GetMapping("{id}")//+
    public LoanForGetDto getById(@PathVariable Integer id) {
        return loanService.getByIdWithDto(id);
    }

    @DeleteMapping("{id}")//+
    public void delete(@PathVariable Integer id) {
        loanService.deleteById(id);
    }

}
