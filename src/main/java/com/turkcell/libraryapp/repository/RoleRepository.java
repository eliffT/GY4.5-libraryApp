package com.turkcell.libraryapp.repository;


import com.turkcell.libraryapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
