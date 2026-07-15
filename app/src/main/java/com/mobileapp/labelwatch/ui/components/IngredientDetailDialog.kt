package com.mobileapp.labelwatch.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.mobileapp.labelwatch.data.models.Ingredient

@Composable
fun IngredientDetailDialog (
    ingredient: Ingredient,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title ={
            Text(ingredient.name)
        },
        text = {
            Text (
                """"Ingredient Score: ${ingredient.ingredientScore}/100
                Category:  ${ingredient.category}
                Purpose: ${ingredient.purpose}
                Why this score ? : ${ingredient.description}
                    """.trimIndent()
            )
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Close")
            }
        }
    )
}