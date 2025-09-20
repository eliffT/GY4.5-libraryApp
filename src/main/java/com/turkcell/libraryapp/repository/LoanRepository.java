package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.entity.enumarations.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>
{

    // Id'si verilen kullanıcının kitap ödünç durumuna göre Loanların sorgulanması
    List<Loan> findByUser_IdAndStatusIn(Integer userId, List<LoanStatus> statuses);

    boolean existsByUser_IdAndBook_IdAndReturnDateIsNull(Integer userId,  Integer bookId);

    int countByUserIdAndStatusIn(Integer userId, List<LoanStatus> statuses);

    // boolean existsByUserIdAndBookIdAndStatus(Long userId, Long bookId, LoanStatus status);
}
