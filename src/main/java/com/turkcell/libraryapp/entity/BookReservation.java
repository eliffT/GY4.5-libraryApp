package com.turkcell.libraryapp.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_reservations")
public class BookReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
