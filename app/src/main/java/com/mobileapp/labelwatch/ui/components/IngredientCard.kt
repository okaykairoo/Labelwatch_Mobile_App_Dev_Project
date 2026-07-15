package com.mobileapp.labelwatch.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileapp.labelwatch.data.models.Ingredient

@Composable
fun IngredientCard(

    ingredient: Ingredient,

    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },

        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Text(

                text = "${ingredient.safetyLevel.emoji()} ${ingredient.name}",

                style = MaterialTheme.typography.titleMedium

            )

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(8.dp))

            Text(

                text = "Ingredient Score: ${ingredient.ingredientScore}/100",

                style = MaterialTheme.typography.bodyLarge

            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(

                text = "Category: ${ingredient.category}"

            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(

                text = "Safety: ${ingredient.safetyLevel.displayName()}"

            )

        }

    }

}