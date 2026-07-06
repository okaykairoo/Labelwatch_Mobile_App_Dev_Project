package com.mobileapp.labelwatch.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileapp.labelwatch.data.models.ProductAnalysis

@Composable
fun ScoreCard(
    analysis: ProductAnalysis
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "Overall Ingredient Score",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "${analysis.overallScore}/100",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${analysis.safetyLevel.emoji()} ${analysis.safetyLevel.displayName()}",
                style = MaterialTheme.typography.titleMedium
            )

        }

    }

}