package com.mobileapp.labelwatch.ui.screens.results


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileapp.labelwatch.data.models.Ingredient
import com.mobileapp.labelwatch.data.models.ProductAnalysis
import com.mobileapp.labelwatch.ui.components.IngredientCard
import com.mobileapp.labelwatch.ui.components.ScoreCard
import com.mobileapp.labelwatch.ui.components.SectionHeader

@Composable
fun ResultsScreen(

    analysis: ProductAnalysis,

    onIngredientClick: (Ingredient) -> Unit

) {
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())

    ) {
        ScoreCard(analysis)

        Spacer(modifier = Modifier.height(24.dp))

        SectionHeader("Recognized Ingredients")

        analysis.recognizedIngredients.forEach { ingredient ->

            IngredientCard(

                ingredient = ingredient,

                onClick = {

                    onIngredientClick(ingredient)

                }

            )

        }

        if (analysis.unknownIngredients.isNotEmpty()) {

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader("Unknown Ingredients")

            analysis.unknownIngredients.forEach {

                Text(

                    text = "🟣 $it",

                    style = MaterialTheme.typography.bodyLarge

                )

            }

        }

    }

}