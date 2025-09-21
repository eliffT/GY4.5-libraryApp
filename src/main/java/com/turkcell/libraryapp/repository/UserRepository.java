package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.User;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select distinct u from User u join u.loans l join l.fine f where f.isPaid = :isPaid and u.id = :userId")
    List<User> findUsersWithUnpaidFines(@Param("userId") Integer userId, @Param("isPaid") boolean isPaid);
    Optional<User> findByUsername(String username);
}
