package com.turkcell.libraryapp.core.utils;

public class ISBNGenerator {

    private static long counter = 0;  // Sıra numarası için sayaç

    // Zaman damgası ve sıra numarası ile ISBN oluştur
    public static String generateTimestampBasedISBN() {
        long timestamp = System.currentTimeMillis();  // Zaman damgası
        long isbnBaseLong = timestamp * 1000 + counter++;  // Zaman damgası + sayaç
        return String.valueOf(isbnBaseLong).substring(0, 13);  // 13 haneli ISBN
    }
}
