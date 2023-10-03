package com.example.zeelo.common.extensions

fun String.toDoubleOrZero(): Double {
    return try {
        toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}