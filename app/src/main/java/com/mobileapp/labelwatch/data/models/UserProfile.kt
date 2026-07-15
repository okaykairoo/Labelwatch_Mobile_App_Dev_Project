package com.mobileapp.labelwatch.data.models

data class UserProfile(
    val name: String = "Food Explorer",
    val joinDate: String = "2026",
    val allergies: List<String> = emptyList()
)