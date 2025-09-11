package com.turkcell.libraryapp.entity.enumarations;

public enum ReservationStatus {

    // Kitap ödünç verilmeden önce rezervasyon sürecini takip eder:
    PENDING,    // Rezervasyon beklemede
    APPROVED,   // Rezervasyon onaylandı
    CANCELLED   // Rezervasyon iptal edildi
}
