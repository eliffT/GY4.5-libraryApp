// src/main/java/com/turkcell/libraryapp/service/LoanService.java
package com.turkcell.libraryapp.service;
import com.turkcell.libraryapp.dto.loan.LoanForAddDto;
import com.turkcell.libraryapp.dto.loan.LoanForGetDto;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.repository.LoanRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    public List<LoanForGetDto> getAllWithDto()
    {
        List<Loan> loans = loanRepository.findAll();
        List<LoanForGetDto> result = new ArrayList<>();

        for (Loan loan : loans) {
            LoanForGetDto dto = new LoanForGetDto();
            dto.setId(loan.getId());
            dto.setBorrowDate(loan.getBorrowDate());
            dto.setReturnDate(loan.getReturnDate());
//            dto.setDelivered(loan.getDelivered());
            result.add(dto);
        }
        return result;
    }


    public LoanForGetDto getByIdWithDto(Integer id)
    {
        Loan loan = loanRepository.findById(id).orElseThrow();
        LoanForGetDto dto = new LoanForGetDto();
        dto.setId(loan.getId());
        dto.setBorrowDate(loan.getBorrowDate());
        dto.setReturnDate(loan.getReturnDate());
//        dto.setDelivered(loan.getDelivered());
        return dto;
    }


    public void deleteById(Integer id)
    {
        loanRepository.deleteById(id);
    }

}
