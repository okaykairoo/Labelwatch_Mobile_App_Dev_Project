package com.mobileapp.labelwatch.domain

object IngredientParser {

    fun parse(text:String): List<String> {
        var cleanedText = text

        cleanedText = cleanedText.replace(
            "INGREDIENTS:",
            "",
            ignoreCase = true
        )

        cleanedText = cleanedText
            .replace(".", "")
            .replace(";", "")
            .replace("\n", ",")

        return cleanedText
            .split(",")
            .map {it.trim()}
            .filter {it.isNotBlank()}
    }


}