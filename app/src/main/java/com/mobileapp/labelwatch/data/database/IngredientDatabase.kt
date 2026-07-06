package com.mobileapp.labelwatch.data.database

import com.mobileapp.labelwatch.data.models.Ingredient
import com.mobileapp.labelwatch.data.models.SafetyLevel

object IngredientDatabase {
    val ingredients = listOf<Ingredient>(
        Ingredient(
            id = "ING001",
            name = "Water",
            category = "Natural",
            ingredientScore = 100,
            safetyLevel = SafetyLevel.GREEN,
            description = "Essential nutrient consitutes most foods processed",
            healthConcerns = listOf(),
            restrictions = listOf("None"),
            aliases = listOf(
                "Water",
                "H20"
            )
        ),

        Ingredient(
            id = "ING002",
            name = "Salt",
            category = "Mineral",
            ingredientScore = 85,
            safetyLevel = SafetyLevel.GREEN,
            description = "Common mineral used for seasoning and preservation.",
            healthConcerns = listOf(
                "High sodium intake may contribute to elevated blood pressure.",
                "Moderation is recommended."
            ),
            restrictions = listOf("No general restriction."),
            aliases = listOf(
                "Salt",
                "Sea Salt",
                "Kosher Salt",
                "Table Salt",
                "Sodium chloride",
                "NaCl"
            )
        ),

        Ingredient(
            id= "ING003",
            name = "Sugar",
            category = "Sweetener",
            ingredientScore = 55,
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common sweetener used in many processed foods",
            healthConcerns = listOf(
                "High intake may contribute to obesity and diabetes type 2",
                "Frequent excess consumption is associated with toth decay"
            ),
            restrictions = listOf("WHO recommends limiting free sugar intake."),
            aliases = listOf(
                "Sucrose",
                "Sugar",
                "Cane sugar"
            )
        ),

        Ingredient(
            id = "ING004",
            name = "Citirc acid",
            category = "Acid",
            ingredientScore = 90,
            safetyLevel = SafetyLevel.GREEN,
            description = "Naturally occuring acid commonly used to enahnce flavor",
            healthConcerns = listOf(
                "Generally accepted and recognized as safe.",
                "Large amounts may irritate sensitive mouths."
            ),
            restrictions = listOf("Approved in mst countries"),
            aliases = listOf(
                "Citric acid",
                "E330"
            )
        ),

        Ingredient(
            id = "ING005",
            name = "Red 40",
            category = "Artificial Color",
            ingredientScore = 20,
            safetyLevel = SafetyLevel.RED,
            description = "Synthrtic food coloring used in beverages, snacks and confectionary",
            healthConcerns = listOf(
                "Some studies suggest possible hyperactivity in sensitive children.",
                "Evidence remains mixed."
            ),
            restrictions = listOf(
                "Some regions require warning consumers."
            ),
            aliases = listOf(
                "Red 40",
                "Allura Red",
                "E129"
            )
        )

    )

    fun getAllIngredients() : List<Ingredient> {
        return ingredients
    }

    fun findByName(name: String) : Ingredient? {
        return ingredients.find {
            it.name.equals(name, ignoreCase = true)
        }
    }

    fun findByAlias(alias: String): Ingredient?{
        return ingredients.find {ingredient ->
            ingredient.aliases.any{
                it.equals(alias, ignoreCase = true)
            }
        }
    }
}