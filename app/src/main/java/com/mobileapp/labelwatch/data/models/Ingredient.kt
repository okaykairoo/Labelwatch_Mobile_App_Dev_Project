package com.mobileapp.labelwatch.data.models

data class Ingredient(
    val id: String,

    val name: String,

    val category: String,

    val ingredientScore: Int,

    val safetyLevel: SafetyLevel,

    val description: String,

    val healthConcerns: List<String>,
    val restrictions: List<String>,
    val aliases: List<String>
)