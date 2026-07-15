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
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import com.mobileapp.labelwatch.session.ScanSession
import com.mobileapp.labelwatch.utils.SafetyMessage
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.mobileapp.labelwatch.ui.components.AllergyAlert
import com.mobileapp.labelwatch.ui.components.IngredientDetailDialog
import com.mobileapp.labelwatch.ui.components.PrimaryButton
import com.mobileapp.labelwatch.ui.components.ScoreCircle
import com.mobileapp.labelwatch.utils.ProductSummary
import com.mobileapp.labelwatch.ui.components.AllergyAlert


@Composable
fun ResultScreen(
    navController: NavHostController
) {

    val analysis = ScanSession.latestAnalysis

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Scan Results",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        var selectedIngredient by remember {
            mutableStateOf<Ingredient?>(null)
        }

        if (analysis != null) {

            ScoreCircle(
                score = analysis.overallScore
            )

            Text(
                SafetyMessage.get(
                    analysis.safetyLevel
                ),
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text= "Summary",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = ProductSummary.create(analysis),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            AllergyAlert(
                ingredients = analysis.recognizedIngredients
            )

            Spacer (modifier = Modifier.height(12.dp))

            Text(
                "Recognized Ingredients",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))



            analysis.recognizedIngredients.forEach { ingredient ->
                IngredientCard(
                    ingredient = ingredient,
                    onClick = {
                        selectedIngredient = ingredient
                    }
                )
            }

            Text(
                "Unknown Ingredients",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))

            analysis.unknownIngredients.forEach {
                Text("▪️${it}")
                Text(
                    text = "Not yet available in the labelwatch database.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

        } else {

            Text("No analysis available.")

        }

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(
            text = "Scan again",
            onClick = {
                navController.popBackStack()
            }
        )

        selectedIngredient?.let {
            IngredientDetailDialog(
                ingredient = it,
                onDismiss = {
                    selectedIngredient = null
                }
            )
        }



    }


}