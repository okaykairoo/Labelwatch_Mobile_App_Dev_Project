package com.mobileapp.labelwatch.utils

import com.mobileapp.labelwatch.data.models.SafetyLevel

object SafetyMessage {

    fun get(level: SafetyLevel): String {

        return when (level) {

            SafetyLevel.GREEN ->
                "Generally Suitable"

            SafetyLevel.YELLOW ->
                "Consume in Moderation"

            SafetyLevel.RED ->
                "Use with Caution"

            SafetyLevel.BLACK ->
                "Avoid Frequent Consumption"

            SafetyLevel.PURPLE ->
                "Insufficient Data"

        }

    }

}