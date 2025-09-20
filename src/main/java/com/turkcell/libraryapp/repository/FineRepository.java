package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.Fine;
import com.turkcell.libraryapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FineRepository extends JpaRepository<Fine, Integer>
{
    // Id'si verilen kullanıcının ödenmemiş cezaları olup olmadığını sorgular.
    boolean existsByLoan_UserIdAndIsPaidFalse(Integer userId);

//    @Query("SELECT f.loan.user FROM Fine f WHERE f.loan.user.id = :userId AND f.isPaid = false")
//    User findUserByLoanUserIdAndIsPaidFalse(Integer userId);


    // Id'si verilen user'a göre cezaları sorgulama
    @Query("SELECT f FROM Fine f WHERE f.loan.user.id = :userId")
    List<Fine> findFinesByUserId(Integer userId);
}
