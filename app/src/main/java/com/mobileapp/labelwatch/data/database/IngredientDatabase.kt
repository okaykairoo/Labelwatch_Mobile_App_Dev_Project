package com.mobileapp.labelwatch.data.database

import com.mobileapp.labelwatch.data.models.Ingredient
import com.mobileapp.labelwatch.data.models.SafetyLevel

object IngredientDatabase {
    val ingredients = listOf<Ingredient>(

        // ========================================
        // NATURAL / COMMON INGREDIENTS
        // ========================================

        Ingredient(
            id = "ING001",
            name = "Water",
            category = "Natural",
            ingredientScore = 100,
            purpose = "Universal solvent and essential nutrient",
            safetyLevel = SafetyLevel.GREEN,
            description = "Essential nutrient and primary component of many foods and beverages.",
            healthConcerns = listOf(),
            restrictions = listOf("None"),
            aliases = listOf("Water", "H2O")
        ),

        Ingredient(
            id = "ING002",
            name = "Salt",
            category = "Mineral",
            ingredientScore = 85,
            purpose = "Seasoning and preservative",
            safetyLevel = SafetyLevel.GREEN,
            description = "Common mineral used for seasoning and food preservation.",
            healthConcerns = listOf(
                "High sodium intake may contribute to elevated blood pressure.",
                "Moderation is recommended."
            ),
            restrictions = listOf("No general restrictions."),
            aliases = listOf("Salt", "Sea Salt", "Kosher Salt", "Table Salt", "Sodium Chloride", "NaCl")
        ),

        Ingredient(
            id = "ING003",
            name = "Sugar",
            category = "Sweetener",
            ingredientScore = 55,
            purpose = "Sweetening agent",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common sweetener used in many processed foods.",
            healthConcerns = listOf(
                "Frequent excess consumption is associated with tooth decay.",
                "High intake may contribute to obesity and type 2 diabetes."
            ),
            restrictions = listOf("WHO recommends limiting free sugar intake."),
            aliases = listOf("Sugar", "Sucrose", "Cane Sugar")
        ),

        // ========================================
        // DAIRY INGREDIENTS
        // ========================================

        Ingredient(
            id = "ING006",
            name = "Milk",
            category = "Dairy",
            ingredientScore = 88,
            purpose = "Dairy base ingredient",
            safetyLevel = SafetyLevel.GREEN,
            description = "Nutritious dairy product containing calcium and protein.",
            healthConcerns = listOf(
                "Not suitable for those with lactose intolerance or dairy allergy."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Milk", "Whole Milk", "Skim Milk", "Cow's Milk")
        ),

        Ingredient(
            id = "ING007",
            name = "Butter",
            category = "Dairy",
            ingredientScore = 70,
            purpose = "Fat and flavoring agent",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Dairy fat used in baking and cooking.",
            healthConcerns = listOf(
                "High in saturated fat.",
                "Consume in moderation."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Butter", "Unsalted Butter", "Salted Butter")
        ),

        Ingredient(
            id = "ING008",
            name = "Cheese",
            category = "Dairy",
            ingredientScore = 75,
            purpose = "Flavoring and ingredient",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Fermented dairy product used in many foods.",
            healthConcerns = listOf(
                "May contain high sodium and saturated fat."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Cheese", "Cheddar", "Mozzarella", "Parmesan")
        ),

        Ingredient(
            id = "ING009",
            name = "Whey",
            category = "Dairy",
            ingredientScore = 80,
            purpose = "Protein source and additive",
            safetyLevel = SafetyLevel.GREEN,
            description = "Dairy protein commonly used in protein supplements and processed foods.",
            healthConcerns = listOf(
                "May cause issues for those with dairy allergies."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Whey", "Whey Protein", "Whey Powder")
        ),

        // ========================================
        // CEREALS / GRAINS
        // ========================================

        Ingredient(
            id = "ING010",
            name = "Wheat Flour",
            category = "Cereal",
            ingredientScore = 85,
            purpose = "Base ingredient for baked goods",
            safetyLevel = SafetyLevel.GREEN,
            description = "Common flour made from wheat, used in breads and baked goods.",
            healthConcerns = listOf(
                "Not suitable for those with celiac disease or gluten sensitivity."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Wheat Flour", "White Flour", "Enriched Flour", "All-Purpose Flour")
        ),

        Ingredient(
            id = "ING011",
            name = "Corn Flour",
            category = "Cereal",
            ingredientScore = 85,
            purpose = "Base ingredient and thickener",
            safetyLevel = SafetyLevel.GREEN,
            description = "Flour made from ground corn, used in tortillas and baked goods.",
            healthConcerns = listOf(
                "Generally safe, may contain trace amounts of gluten."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Corn Flour", "Cornmeal", "Maize Flour")
        ),

        Ingredient(
            id = "ING012",
            name = "Rice Flour",
            category = "Cereal",
            ingredientScore = 90,
            purpose = "Gluten-free flour alternative",
            safetyLevel = SafetyLevel.GREEN,
            description = "Gluten-free flour made from rice.",
            healthConcerns = listOf(),
            restrictions = listOf("None"),
            aliases = listOf("Rice Flour", "White Rice Flour", "Brown Rice Flour")
        ),

        Ingredient(
            id = "ING013",
            name = "Oats",
            category = "Cereal",
            ingredientScore = 88,
            purpose = "Cereal grain and ingredient",
            safetyLevel = SafetyLevel.GREEN,
            description = "Whole grain cereal used in porridge and baking.",
            healthConcerns = listOf(
                "May contain gluten from cross-contamination."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Oats", "Rolled Oats", "Oatmeal")
        ),

        // ========================================
        // OILS
        // ========================================

        Ingredient(
            id = "ING014",
            name = "Vegetable Oil",
            category = "Oil",
            ingredientScore = 72,
            purpose = "Cooking and ingredient",
            safetyLevel = SafetyLevel.YELLOW,
            description = "General term for plant-based oils used in cooking.",
            healthConcerns = listOf(
                "May contain trans fats.",
                "Choose healthier oil options."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Vegetable Oil", "Cooking Oil", "Soybean Oil", "Canola Oil")
        ),

        Ingredient(
            id = "ING015",
            name = "Olive Oil",
            category = "Oil",
            ingredientScore = 90,
            purpose = "Cooking and flavoring",
            safetyLevel = SafetyLevel.GREEN,
            description = "Heart-healthy oil from olives.",
            healthConcerns = listOf(),
            restrictions = listOf("None"),
            aliases = listOf("Olive Oil", "Extra Virgin Olive Oil", "EVOO")
        ),

        Ingredient(
            id = "ING016",
            name = "Palm Oil",
            category = "Oil",
            ingredientScore = 60,
            purpose = "Cooking and ingredient",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Vegetable oil derived from palm fruit.",
            healthConcerns = listOf(
                "High in saturated fat.",
                "Environmental sustainability concerns."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Palm Oil", "Palm Fruit Oil")
        ),

        Ingredient(
            id = "ING017",
            name = "Sunflower Oil",
            category = "Oil",
            ingredientScore = 78,
            purpose = "Cooking and ingredient",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Vegetable oil from sunflower seeds.",
            healthConcerns = listOf(
                "High in omega-6 fatty acids."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Sunflower Oil", "Sunflower Seed Oil")
        ),

        // ========================================
        // ARTIFICIAL COLORS
        // ========================================

        Ingredient(
            id = "ING005",
            name = "Red 40",
            category = "Artificial Color",
            ingredientScore = 20,
            purpose = "Food coloring",
            safetyLevel = SafetyLevel.RED,
            description = "Synthetic food coloring used in beverages, snacks and confectionery.",
            healthConcerns = listOf(
                "Some studies suggest possible hyperactivity in sensitive children.",
                "Evidence remains mixed."
            ),
            restrictions = listOf("Some regions require warning labels."),
            aliases = listOf("Red 40", "Allura Red", "E129")
        ),

        Ingredient(
            id = "ING018",
            name = "Yellow 5",
            category = "Artificial Color",
            ingredientScore = 18,
            purpose = "Food coloring",
            safetyLevel = SafetyLevel.RED,
            description = "Synthetic yellow food coloring used in processed foods.",
            healthConcerns = listOf(
                "May cause allergic reactions in sensitive individuals.",
                "Potential hyperactivity concerns."
            ),
            restrictions = listOf("Some regions require warning labels."),
            aliases = listOf("Yellow 5", "Tartrazine", "E102")
        ),

        Ingredient(
            id = "ING019",
            name = "Yellow 6",
            category = "Artificial Color",
            ingredientScore = 18,
            purpose = "Food coloring",
            safetyLevel = SafetyLevel.RED,
            description = "Synthetic yellow-orange food coloring.",
            healthConcerns = listOf(
                "Possible hyperactivity concerns.",
                "May cause allergic reactions."
            ),
            restrictions = listOf("Some regions require warning labels."),
            aliases = listOf("Yellow 6", "Sunset Yellow", "E110")
        ),

        Ingredient(
            id = "ING020",
            name = "Blue 1",
            category = "Artificial Color",
            ingredientScore = 18,
            purpose = "Food coloring",
            safetyLevel = SafetyLevel.RED,
            description = "Synthetic blue food coloring.",
            healthConcerns = listOf(
                "May cause allergic reactions."
            ),
            restrictions = listOf("Some regions require warning labels."),
            aliases = listOf("Blue 1", "Brilliant Blue", "E133")
        ),

        // ========================================
        // ACIDS
        // ========================================

        Ingredient(
            id = "ING004",
            name = "Citric Acid",
            category = "Acid",
            ingredientScore = 90,
            purpose = "Flavoring and preservative",
            safetyLevel = SafetyLevel.GREEN,
            description = "Naturally occurring acid commonly used to enhance flavor and preserve foods.",
            healthConcerns = listOf(
                "Generally recognized as safe.",
                "Large amounts may irritate sensitive mouths."
            ),
            restrictions = listOf("Approved in most countries."),
            aliases = listOf("Citric Acid", "E330")
        ),

        Ingredient(
            id = "ING021",
            name = "Ascorbic Acid",
            category = "Acid",
            ingredientScore = 95,
            purpose = "Antioxidant and preservative",
            safetyLevel = SafetyLevel.GREEN,
            description = "Vitamin C, used as an antioxidant and preservative.",
            healthConcerns = listOf(),
            restrictions = listOf("None"),
            aliases = listOf("Ascorbic Acid", "Vitamin C", "E300")
        ),

        Ingredient(
            id = "ING022",
            name = "Lactic Acid",
            category = "Acid",
            ingredientScore = 85,
            purpose = "Acidulant and preservative",
            safetyLevel = SafetyLevel.GREEN,
            description = "Organic acid used in food preservation and flavoring.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Lactic Acid", "E270")
        ),

        Ingredient(
            id = "ING023",
            name = "Malic Acid",
            category = "Acid",
            ingredientScore = 85,
            purpose = "Flavor enhancer",
            safetyLevel = SafetyLevel.GREEN,
            description = "Naturally occurring acid found in apples and other fruits.",
            healthConcerns = listOf(),
            restrictions = listOf("None"),
            aliases = listOf("Malic Acid", "E296")
        ),

        // ========================================
        // PRESERVATIVES
        // ========================================

        Ingredient(
            id = "ING024",
            name = "Sodium Benzoate",
            category = "Preservative",
            ingredientScore = 60,
            purpose = "Food preservative",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common synthetic preservative used in acidic foods.",
            healthConcerns = listOf(
                "May form benzene when combined with ascorbic acid.",
                "Use in moderation."
            ),
            restrictions = listOf("Approved in most countries."),
            aliases = listOf("Sodium Benzoate", "E211")
        ),

        Ingredient(
            id = "ING025",
            name = "Potassium Sorbate",
            category = "Preservative",
            ingredientScore = 70,
            purpose = "Food preservative",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common preservative used to prevent mold and yeast growth.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Potassium Sorbate", "E202")
        ),

        Ingredient(
            id = "ING026",
            name = "Calcium Propionate",
            category = "Preservative",
            ingredientScore = 75,
            purpose = "Mold inhibitor",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common preservative used in bread and baked goods.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Calcium Propionate", "E282")
        ),

        // ========================================
        // FLAVOR ENHANCERS
        // ========================================

        Ingredient(
            id = "ING027",
            name = "Monosodium Glutamate",
            category = "Flavor Enhancer",
            ingredientScore = 55,
            purpose = "Flavor enhancer",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common flavor enhancer used in Asian cuisine and processed foods.",
            healthConcerns = listOf(
                "Some people report sensitivity to MSG.",
                "Scientific evidence for widespread harm is limited."
            ),
            restrictions = listOf("Approved for use in most countries."),
            aliases = listOf("MSG", "Monosodium Glutamate", "E621")
        ),

        Ingredient(
            id = "ING028",
            name = "Disodium Inosinate",
            category = "Flavor Enhancer",
            ingredientScore = 55,
            purpose = "Flavor enhancer",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Flavor enhancer often used with MSG.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Disodium Inosinate", "E631")
        ),

        Ingredient(
            id = "ING029",
            name = "Disodium Guanylate",
            category = "Flavor Enhancer",
            ingredientScore = 55,
            purpose = "Flavor enhancer",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Flavor enhancer used in processed foods.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Disodium Guanylate", "E627")
        ),

        // ========================================
        // SWEETENERS
        // ========================================

        Ingredient(
            id = "ING030",
            name = "Aspartame",
            category = "Sweetener",
            ingredientScore = 40,
            purpose = "Artificial sweetener",
            safetyLevel = SafetyLevel.RED,
            description = "Low-calorie artificial sweetener used in diet products.",
            healthConcerns = listOf(
                "Not suitable for people with PKU.",
                "Controversial safety profile."
            ),
            restrictions = listOf("Approved in most countries."),
            aliases = listOf("Aspartame", "E951")
        ),

        Ingredient(
            id = "ING031",
            name = "Sucralose",
            category = "Sweetener",
            ingredientScore = 45,
            purpose = "Artificial sweetener",
            safetyLevel = SafetyLevel.RED,
            description = "Zero-calorie artificial sweetener.",
            healthConcerns = listOf(
                "Mixed evidence on long-term safety."
            ),
            restrictions = listOf("Approved in most countries."),
            aliases = listOf("Sucralose", "E955")
        ),

        Ingredient(
            id = "ING032",
            name = "Stevia",
            category = "Sweetener",
            ingredientScore = 75,
            purpose = "Natural sweetener",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Natural zero-calorie sweetener from the stevia plant.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Stevia", "Steviol Glycosides", "E960")
        ),

        // ========================================
        // GUMS / EMULSIFIERS
        // ========================================

        Ingredient(
            id = "ING033",
            name = "Soy Lecithin",
            category = "Emulsifier",
            ingredientScore = 75,
            purpose = "Emulsifier and thickener",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common emulsifier derived from soybeans.",
            healthConcerns = listOf(
                "May cause issues for those with soy allergies.",
                "Often derived from GMO soy."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Soy Lecithin", "E322", "Lecithin")
        ),

        Ingredient(
            id = "ING034",
            name = "Sunflower Lecithin",
            category = "Emulsifier",
            ingredientScore = 80,
            purpose = "Emulsifier and thickener",
            safetyLevel = SafetyLevel.GREEN,
            description = "Emulsifier derived from sunflower seeds.",
            healthConcerns = listOf(),
            restrictions = listOf("None"),
            aliases = listOf("Sunflower Lecithin", "Lecithin")
        ),

        Ingredient(
            id = "ING035",
            name = "Xanthan Gum",
            category = "Gum",
            ingredientScore = 75,
            purpose = "Thickener and stabilizer",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common food thickener used in sauces and dressings.",
            healthConcerns = listOf(
                "May cause digestive issues in large amounts."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Xanthan Gum", "E415")
        ),

        Ingredient(
            id = "ING036",
            name = "Guar Gum",
            category = "Gum",
            ingredientScore = 78,
            purpose = "Thickener and stabilizer",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Natural thickener derived from guar beans.",
            healthConcerns = listOf(
                "May cause digestive issues in large amounts."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Guar Gum", "E412")
        ),

        // ========================================
        // CHEMICAL COMPOUNDS / OTHER ADDITIVES
        // ========================================

        Ingredient(
            id = "ING037",
            name = "Maltodextrin",
            category = "Additive",
            ingredientScore = 60,
            purpose = "Thickener and filler",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common carbohydrate used as a thickener in processed foods.",
            healthConcerns = listOf(
                "High glycemic index.",
                "May cause blood sugar spikes."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Maltodextrin", "Modified Corn Starch")
        ),

        Ingredient(
            id = "ING038",
            name = "High Fructose Corn Syrup",
            category = "Sweetener",
            ingredientScore = 35,
            purpose = "Sweetener and preservative",
            safetyLevel = SafetyLevel.RED,
            description = "Common sweetener derived from corn.",
            healthConcerns = listOf(
                "Associated with obesity and metabolic disorders.",
                "May contain mercury."
            ),
            restrictions = listOf("None"),
            aliases = listOf("HFCS", "High Fructose Corn Syrup", "Corn Syrup")
        ),

        Ingredient(
            id = "ING039",
            name = "Sodium Nitrite",
            category = "Preservative",
            ingredientScore = 30,
            purpose = "Meat preservative and color fixative",
            safetyLevel = SafetyLevel.RED,
            description = "Common preservative in processed meats.",
            healthConcerns = listOf(
                "May form carcinogenic compounds when heated.",
                "Linked to increased cancer risk."
            ),
            restrictions = listOf("Restricted in some regions."),
            aliases = listOf("Sodium Nitrite", "E250")
        ),

        Ingredient(
            id = "ING040",
            name = "Sodium Metabisulfite",
            category = "Preservative",
            ingredientScore = 45,
            purpose = "Preservative and antioxidant",
            safetyLevel = SafetyLevel.RED,
            description = "Common preservative in dried fruits and wines.",
            healthConcerns = listOf(
                "May cause allergic reactions in sensitive individuals.",
                "May trigger asthma."
            ),
            restrictions = listOf("Some regions require warning labels."),
            aliases = listOf("Sodium Metabisulfite", "E223")
        ),

        // ========================================
        // FLAVORINGS (NATURAL & ARTIFICIAL)
        // ========================================

        Ingredient(
            id = "ING041",
            name = "Natural Flavor",
            category = "Flavoring",
            ingredientScore = 65,
            purpose = "Flavoring",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Natural flavorings derived from natural sources.",
            healthConcerns = listOf(
                "Composition is proprietary and undisclosed.",
                "May contain multiple compounds."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Natural Flavor", "Natural Flavors")
        ),

        Ingredient(
            id = "ING042",
            name = "Artificial Flavor",
            category = "Flavoring",
            ingredientScore = 50,
            purpose = "Flavoring",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Synthetic flavorings used to enhance taste.",
            healthConcerns = listOf(
                "Composition is proprietary.",
                "Some artificial flavors may be controversial."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Artificial Flavor", "Artificial Flavors")
        ),

        // ========================================
        // ADDITIONAL EUROPEAN E-CODES
        // ========================================

        Ingredient(
            id = "ING043",
            name = "Ethyl Alcohol",
            category = "Additive",
            ingredientScore = 55,
            purpose = "Solvent and preservative",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common solvent used in food processing.",
            healthConcerns = listOf(
                "May be controversial in some products."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Ethyl Alcohol", "Ethanol", "Alcohol", "E1510")
        ),

        Ingredient(
            id = "ING044",
            name = "Propylene Glycol",
            category = "Additive",
            ingredientScore = 55,
            purpose = "Humectant and solvent",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common additive used to maintain moisture.",
            healthConcerns = listOf(
                "Generally recognized as safe in small amounts."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Propylene Glycol", "E1520")
        ),

        Ingredient(
            id = "ING045",
            name = "Sodium Propionate",
            category = "Preservative",
            ingredientScore = 70,
            purpose = "Mold inhibitor",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common preservative used in baked goods.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Sodium Propionate", "E281")
        ),

        Ingredient(
            id = "ING046",
            name = "Sorbic Acid",
            category = "Preservative",
            ingredientScore = 70,
            purpose = "Mold and yeast inhibitor",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common preservative used in cheese and baked goods.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Sorbic Acid", "E200")
        ),

        Ingredient(
            id = "ING047",
            name = "Ammonium Chloride",
            category = "Additive",
            ingredientScore = 65,
            purpose = "Flavoring and processing aid",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Common additive in confectionery and bakery.",
            healthConcerns = listOf(
                "Generally recognized as safe."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Ammonium Chloride", "E510")
        ),

        // ========================================
        // EXTRA COMMON INGREDIENTS
        // ========================================

        Ingredient(
            id = "ING048",
            name = "Honey",
            category = "Natural",
            ingredientScore = 88,
            purpose = "Natural sweetener",
            safetyLevel = SafetyLevel.GREEN,
            description = "Natural sweetener produced by bees.",
            healthConcerns = listOf(
                "Not suitable for infants under 1 year."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Honey", "Raw Honey")
        ),

        Ingredient(
            id = "ING049",
            name = "Coconut Oil",
            category = "Oil",
            ingredientScore = 68,
            purpose = "Cooking and ingredient",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Vegetable oil from coconut.",
            healthConcerns = listOf(
                "High in saturated fat."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Coconut Oil")
        ),

        Ingredient(
            id = "ING050",
            name = "Cocoa Butter",
            category = "Fat",
            ingredientScore = 75,
            purpose = "Fat and flavoring",
            safetyLevel = SafetyLevel.YELLOW,
            description = "Natural fat from cocoa beans used in chocolate.",
            healthConcerns = listOf(
                "High in saturated fat."
            ),
            restrictions = listOf("None"),
            aliases = listOf("Cocoa Butter")
        ),

        Ingredient(
            id="ING051",
            name = "Soy sauce",
            category = "sauce",
            ingredientScore = 70,
            purpose = "Flavoring",
            safetyLevel =  SafetyLevel.GREEN,
            description = "Natural flavoring made form soy beans",
            healthConcerns =  listOf(
                "None yet"
            ),
            restrictions = listOf("none"),
            aliases = listOf("Soy sauce")
        ),


    )

    fun getAllIngredients(): List<Ingredient> {
        return ingredients
    }

    fun findByName(name: String): Ingredient? {
        return ingredients.find {
            it.name.equals(name, ignoreCase = true)
        }
    }

    fun findByAlias(alias: String): Ingredient? {
        return ingredients.find { ingredient ->
            ingredient.aliases.any {
                it.equals(alias, ignoreCase = true)
            }
        }
    }
}