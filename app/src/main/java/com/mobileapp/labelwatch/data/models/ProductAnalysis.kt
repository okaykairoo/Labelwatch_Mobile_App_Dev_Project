package com.mobileapp.labelwatch.data.models

data class ProductAnalysis(

    val overallScore: Int,

    val safetyLevel: SafetyLevel,

    val recognizedIngredients: List<Ingredient>,

    val unknownIngredients: List<String>

)