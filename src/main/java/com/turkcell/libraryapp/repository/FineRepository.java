package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Integer>
{
}
