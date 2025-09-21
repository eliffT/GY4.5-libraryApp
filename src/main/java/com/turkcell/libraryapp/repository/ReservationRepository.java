package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<BookReservation, Integer> {
}
