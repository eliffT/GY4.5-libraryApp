package com.turkcell.libraryapp.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "operation_claims")

public class OperationClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
