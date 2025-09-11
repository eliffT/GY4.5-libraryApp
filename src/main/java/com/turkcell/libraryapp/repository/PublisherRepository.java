package com.turkcell.libraryapp.repository;


import com.turkcell.libraryapp.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
