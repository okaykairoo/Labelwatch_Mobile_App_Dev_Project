package com.mobileapp.labelwatch.utils

import com.mobileapp.labelwatch.data.models.ProductAnalysis
import com.mobileapp.labelwatch.data.models.SafetyLevel

object ProductSummary {

    fun create(
        analysis: ProductAnalysis
    ): String {

        return when (analysis.safetyLevel) {

            SafetyLevel.GREEN ->
                "This product contains mostly low-risk ingredients and is generally considered suitable."

            SafetyLevel.YELLOW ->
                "Most ingredients are considered acceptable, although some should be consumed in moderation."

            SafetyLevel.RED ->
                "Several ingredients may raise concerns. Review the ingredient list before regular consumption."

            SafetyLevel.BLACK ->
                "This product contains multiple high-risk ingredients. Consider healthier alternatives."

            SafetyLevel.PURPLE ->
                "Not enough ingredients were recognized to provide a reliable recommendation."
        }

    }

}