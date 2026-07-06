package com.mobileapp.labelwatch.domain

import com.mobileapp.labelwatch.data.models.IngredientMatchResult
import com.mobileapp.labelwatch.data.models.ProductAnalysis
import com.mobileapp.labelwatch.data.models.SafetyLevel

object ProductAnalyzer {
    fun analyze(
        result: IngredientMatchResult
    ): ProductAnalysis {

        val recognized = result.recognizedIngredients

        if (recognized.isEmpty()) {
            return ProductAnalysis(
                overallScore = 0,
                safetyLevel = SafetyLevel.PURPLE,
                recognizedIngredients = recognized,
                unknownIngredients = result.unknownIngredients
            )
        }

        val totalScore = recognized.sumOf { it.ingredientScore }

        val averageScore = totalScore / recognized.size

        val safety = when (averageScore) {
            in 90..100 -> SafetyLevel.GREEN
            in 70..89 -> SafetyLevel.YELLOW
            in 40..69 -> SafetyLevel.RED
            in 1..39 -> SafetyLevel.BLACK
            else -> SafetyLevel.PURPLE
        }

        return ProductAnalysis(
            overallScore = averageScore,
            safetyLevel = safety,
            recognizedIngredients = recognized,
            unknownIngredients = result.unknownIngredients
        )
    }
}