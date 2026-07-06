package com.mobileapp.labelwatch.data.models

data class IngredientMatchResult (
    val recognizedIngredients: List<Ingredient>,
    val unknownIngredients: List<String>
)