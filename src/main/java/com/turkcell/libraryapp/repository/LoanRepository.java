package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>
{

}
