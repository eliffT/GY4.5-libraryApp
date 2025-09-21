package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.entity.enumList.ReservationStatus;
import com.turkcell.libraryapp.repository.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationBusinessRules {

    private final ReservationRepository reservationRepository;

    public ReservationBusinessRules(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void checkReservationRules(Book book, User user){
        if (book.getAvailableCopies() > 0) {
            throw new RuntimeException("Stok mevcut, rezervasyon yapılamaz. Kitap direkt ödünç alınmalı.");
        }

        boolean hasActiveReservation = reservationRepository.existsByBookIdAndUserIdAndStatus(
                book.getId(), user.getId(), ReservationStatus.ACTIVE);

        if (hasActiveReservation) {
            throw new RuntimeException("Zaten bu kitap için aktif rezervasyonunuz var.");
        }
    }

}
