package com.turkcell.libraryapp.entity;

public enum LoanStatus {

    // Kitap kullanıcıya verildikten sonra takip edilen durumlar:
    BORROWED,   // Kitap ödünç alınmış
    RETURNED,   // Kitap iade edilmiş
    LATE        // Teslim tarihi geçmiş
}
