package com.turkcell.libraryapp.entity;

public enum ReservationStatus {

    // Kitap ödünç verilmeden önce rezervasyon sürecini takip eder:
    PENDING,    // Rezervasyon beklemede
    APPROVED,   // Rezervasyon onaylandı
    CANCELLED   // Rezervasyon iptal edildi
}
