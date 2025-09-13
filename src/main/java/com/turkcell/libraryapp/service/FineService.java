package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.fine.request.FineRequest;
import com.turkcell.libraryapp.dto.fine.response.FineResponse;
import com.turkcell.libraryapp.entity.Fine;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.repository.FineRepository;
import com.turkcell.libraryapp.repository.LoanRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FineService {

    private final FineRepository fineRepository;
    private final LoanRepository loanRepository;

    public FineService(FineRepository fineRepository, LoanRepository loanRepository) {
        this.fineRepository = fineRepository;
        this.loanRepository = loanRepository;
    }

    public FineResponse addWithDto(FineRequest request) {
        Fine fine = new Fine();
        fine.setIsPaid(request.getIsPaid());
        fine.setAmount(request.getAmount());

        Loan loan = loanRepository.findById(request.getLoanId()).orElseThrow();
        fine.setLoan(loan);

        Fine saved = fineRepository.save(fine);
        return convertToDto(saved);
    }

    public List<FineResponse> getAllWithDto() {
        List<Fine> fineList = fineRepository.findAll();
        List<FineResponse> response = new ArrayList<>();

        for (Fine fine : fineList) {
            response.add(convertToDto(fine));
        }
        return response;
    }

    public FineResponse getByIdWithDto(Integer id) {
        Fine fine = fineRepository.findById(id).orElseThrow();
        return convertToDto(fine);
    }

    public FineResponse updateWithDto(Integer id, FineRequest request) {
        Fine fine = fineRepository.findById(id).orElseThrow();

        fine.setIsPaid(request.getIsPaid());
        fine.setAmount(request.getAmount());

        Loan loan = loanRepository.findById(request.getLoanId()).orElseThrow();
        fine.setLoan(loan);

        Fine updated = fineRepository.save(fine);
        return convertToDto(updated);
    }

    public void deleteById(Integer id) {
        fineRepository.deleteById(id);
    }

    private FineResponse convertToDto(Fine fine) {
        FineResponse dto = new FineResponse();
        dto.setId(fine.getId());
        dto.setIsPaid(fine.getIsPaid());
        dto.setAmount(fine.getAmount());
        dto.setLoanId(fine.getLoan() != null ? fine.getLoan().getId() : null);
        return dto;
    }
}
