package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.repository.FineRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Component
public class FineBusinessRules {

    private final FineRepository fineRepository;

    private static final double DAILY_FINE_AMOUNT = 5; // günlük 5₺ gecikme cezası

    public FineBusinessRules(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    // Üyenin ödenmemiş cezası var mı?
    public void validateUserHasUnpaidFines(User user){
        boolean hasUnpaidFine = fineRepository.existsByLoan_UserIdAndIsPaidFalse(user.getId());
        if (hasUnpaidFine) {
            throw new RuntimeException("User has unpaid fines");
        }
    }

    // Gecikme cezası hesaplama
    public double calculateLateFee(LocalDate dueDate, LocalDate returnDate){
        if(returnDate.isAfter(dueDate)){
            long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
            double fine = 0;
            for(int i = 1; i <= daysLate; i++){
                fine += i * DAILY_FINE_AMOUNT;
            }
            return fine;
        }
        return 0;
    }


}
