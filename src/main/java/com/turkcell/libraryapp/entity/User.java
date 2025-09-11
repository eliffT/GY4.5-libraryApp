package com.turkcell.libraryapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

   // @Column(nullable = false)
    private String password;

    private String email;
    private String phone;

    @CreationTimestamp      // Otomatik tarih ataması yapılır.
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    private Role role = Role.MEMBER;

    public User() {
        this.isActive = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
