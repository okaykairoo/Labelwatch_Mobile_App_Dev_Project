package com.mobileapp.labelwatch.domain

import com.mobileapp.labelwatch.data.database.IngredientDatabase
import com.mobileapp.labelwatch.data.models.Ingredient
import com.mobileapp.labelwatch.data.models.IngredientMatchResult
import com.mobileapp.labelwatch.domain.IngredientParser

object IngredientMatcher {
    fun matchIngredients(text: String) : IngredientMatchResult{
        val recognized = mutableListOf<Ingredient>()
        val unknown = mutableListOf<String>()

        val words = IngredientParser.parse(text)
        for (word in words) {
            val cleanedWord = word.trim()
            val ingredient =
                IngredientDatabase.findByAlias(cleanedWord)
                    ?: IngredientDatabase.findByName(cleanedWord)

            if (ingredient != null){
                recognized.add(ingredient)
            } else {
                if (cleanedWord.isNotBlank()){
                    unknown.add(cleanedWord)
                }
            }
        }

        return IngredientMatchResult(
            recognizedIngredients = recognized,
            unknownIngredients = unknown
        )
    }
}