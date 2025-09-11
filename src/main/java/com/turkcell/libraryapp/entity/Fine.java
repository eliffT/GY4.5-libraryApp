package com.turkcell.libraryapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fines")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_paid")
    private Boolean ispaid;

    private int amount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIspaid() {
        return ispaid;
    }

    public void setIspaid(Boolean ispaid) {
        this.ispaid = ispaid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
