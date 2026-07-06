package com.mobileapp.labelwatch.data.models

enum class SafetyLevel {

    GREEN,
    YELLOW,
    RED,
    BLACK,
    PURPLE;

    fun displayName(): String {

        return when (this) {

            GREEN -> "Safe"

            YELLOW -> "Moderate"

            RED -> "Avoid"

            BLACK -> "Banned"

            PURPLE -> "Unknown"

        }

    }

    fun emoji(): String {
        return when (this) {
             GREEN -> "🟢"
             YELLOW -> "\uD83D\uDFE1"
             RED ->"🔴"
            BLACK ->"⚫"
             PURPLE ->"\uD83D\uDFE3"

        }
    }

}