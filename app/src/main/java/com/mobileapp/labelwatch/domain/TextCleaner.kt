package com.mobileapp.labelwatch.domain

object TextCleaner {
    fun clean(text: String): String{
        return text
            .replace("\n", "")
            .replace(Regex("\\s+"), "")
            .trim()
    }
}