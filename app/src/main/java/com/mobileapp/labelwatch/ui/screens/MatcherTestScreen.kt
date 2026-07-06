package com.mobileapp.labelwatch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Button
import com.mobileapp.labelwatch.data.models.IngredientMatchResult
import com.mobileapp.labelwatch.domain.IngredientMatcher
import com.mobileapp.labelwatch.domain.ProductAnalyzer
import com.mobileapp.labelwatch.data.models.ProductAnalysis
import com.mobileapp.labelwatch.ui.components.IngredientCard


@Composable
fun MatcherTestScreen() {

    var inputText by remember {
        mutableStateOf("")
    }

    var matchResult by remember {
        mutableStateOf<IngredientMatchResult?>(null)
    }

    var analysis by remember {

        mutableStateOf<ProductAnalysis?>(null)

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ingredient Matcher Test",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = {
                inputText = it
            },
            label = {
                Text("Paste OCR Text")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                matchResult = IngredientMatcher.matchIngredients(inputText)
                analysis = ProductAnalyzer.analyze(matchResult!!)
            }
        ) {
            Text("Text Match")
        }

        Spacer(modifier = Modifier.height(24.dp))

        matchResult?.let {
            result ->

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Recognized Ingredients",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            analysis?.let { product ->

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Overall Ingredient Score",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "${product.overallScore}/100",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Safety: ${product.safetyLevel}"
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

            result.recognizedIngredients.forEach { ingredient ->
                IngredientCard(
                    ingredient = ingredient,
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Unknown ingredient",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            result.unknownIngredients.forEach { unknown ->
                Text("❓ $unknown")
            }
        }

    }

}