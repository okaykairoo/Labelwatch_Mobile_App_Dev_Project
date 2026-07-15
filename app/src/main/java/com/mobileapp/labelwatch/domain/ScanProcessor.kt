package com.mobileapp.labelwatch.domain
import com.mobileapp.labelwatch.data.models.ProductAnalysis



object ScanProcessor {
    fun process(
        detectedText: String
    ): ProductAnalysis {
        val cleanedText = TextCleaner.clean(detectedText)
        val matchResult = IngredientMatcher.matchIngredients(cleanedText)
        return ProductAnalyzer.analyze(matchResult)
    }
}