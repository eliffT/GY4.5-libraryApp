package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.fine.request.FineRequest;
import com.turkcell.libraryapp.dto.fine.response.FinePayResponse;
import com.turkcell.libraryapp.dto.fine.response.FineResponse;
import com.turkcell.libraryapp.entity.Fine;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.mapper.FineMapper;
import com.turkcell.libraryapp.repository.FineRepository;
import com.turkcell.libraryapp.repository.LoanRepository;
import com.turkcell.libraryapp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Service
@Validated
public class FineService {

    private final FineRepository fineRepository;
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final FineMapper fineMapper;

    public FineService(FineRepository fineRepository, LoanRepository loanRepository,
                       UserRepository userRepository, FineMapper fineMapper) {
        this.fineRepository = fineRepository;
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.fineMapper = fineMapper;
    }

    public FineResponse createFine(@Valid FineRequest request) {
        Loan loan = loanRepository.findById(request.getLoanId())
                .orElseThrow(() -> new EntityNotFoundException("Loan not found"));

        Fine fine = fineMapper.fineRequestToFine(request);
        fine.setLoan(loan);

        Fine saved = fineRepository.save(fine);
        return fineMapper.fineToFineResponse(saved);
    }

    public List<FineResponse> getAllFines() {
        List<Fine> fineList = fineRepository.findAll();
        return fineMapper.fineToFineResponseList(fineList);
    }

    public FineResponse getFineById(Integer id) {
        Fine fine = fineRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Fine not found"));
        return fineMapper.fineToFineResponse(fine);
    }

    public FineResponse updateFine(Integer id, FineRequest request) {
        Fine fine = fineRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Fine not found"));

        fine.setPaid(request.isPaid());
        fine.setAmount(request.getAmount());

        Loan loan = loanRepository.findById(request.getLoanId()).orElseThrow(()-> new RuntimeException("Loan Not Found"));
        fine.setLoan(loan);

        Fine updated = fineRepository.save(fine);
        return fineMapper.fineToFineResponse(updated);
    }

    public void deleteFineById(Integer id) {
        fineRepository.deleteById(id);
    }

    public List<FineResponse> getFineByUserId(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User Not Found"));
        List<Fine> fineList= fineRepository.findFinesByUserId(id);
        return fineMapper.fineToFineResponseList(fineList);
    }

    public FinePayResponse payFine(Integer id) {
        Fine fine = fineRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Fine not found"));

        // Ödenme durumu kontrolü - business rule
        if(fine.isPaid()){
            throw new IllegalStateException("Fine is already paid");
        }
        fine.setPaid(true);
        fine.setPaymentDate(LocalDate.now());

        fineRepository.save(fine);
        return fineMapper.fineToFinePayResponse(fine);
    }

}
