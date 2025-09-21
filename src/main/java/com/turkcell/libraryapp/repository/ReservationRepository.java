package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.BookReservation;
import com.turkcell.libraryapp.entity.enumList.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<BookReservation, Integer> {

    boolean existsByBookIdAndUserIdAndStatus(Integer bookId, Integer userId, ReservationStatus status);

    List<BookReservation> findByBookIdAndStatusOrderByCreatedAtAsc(Integer bookId, ReservationStatus status);

}
