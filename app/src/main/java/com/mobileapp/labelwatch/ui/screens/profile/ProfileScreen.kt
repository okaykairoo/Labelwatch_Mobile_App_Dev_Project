package com.mobileapp.labelwatch.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileapp.labelwatch.ui.screens.history.HistoryManager
import com.mobileapp.labelwatch.session.ProfileManager

@Composable
fun ProfileScreen() {

    val profile = ProfileManager.getProfile()
    var showAllergyDialog by remember { mutableStateOf(false) }
    var newAllergy by remember { mutableStateOf("") }

    // Calculate statistics
    val history = HistoryManager.getHistory()
    val totalScans = history.size
    val averageScore = if (history.isNotEmpty()) {
        history.map { it.overallScore }.average().toInt()
    } else {
        0
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // ======================
        // 1. Profile Card
        // ======================
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Avatar
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "👤",
                            fontSize = 32.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = profile.name,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "LabelWatch Explorer since ${profile.joinDate}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }

        // ======================
        // 2. Statistics Card
        // ======================
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "📊 Your Stats",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "$totalScans",
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = "Scans",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "",
                                style = MaterialTheme.typography.headlineMedium
                            )
                            Text(
                                text = "Avg. Score",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }

        // ======================
        // 3. Allergies Section
        // ======================
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🌾 Food Allergies",
                            style = MaterialTheme.typography.titleMedium
                        )

                        TextButton(
                            onClick = { showAllergyDialog = true }
                        ) {
                            Text("+ Add")
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    if (profile.allergies.isEmpty()) {
                        Text(
                            text = "No allergies added. Tap 'Add' to set your allergies.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    } else {
                        profile.allergies.forEach { allergy ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "⚠️ $allergy",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.error
                                )

                                IconButton(
                                    onClick = { ProfileManager.removeAllergy(allergy) }
                                ) {
                                    Text("✕", color = MaterialTheme.colorScheme.error)
                                }
                            }
                        }
                    }
                }
            }
        }

        // ======================
        // 4. Allergy Warning Preview
        // ======================
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "🔔 Allergy Alert Feature",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "When you scan a product, LabelWatch will automatically check if any ingredients match your allergies and show a warning.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        // ======================
        // 5. About / Team Message
        // ======================
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "💚 About LabelWatch",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "LabelWatch helps consumers understand food ingredients by scanning labels and providing safety scores.",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "📌 Version 1.0",
                        style = MaterialTheme.typography.bodySmall
                    )

                    Text(
                        text = "Built with ❤️ for better food choices",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // ======================
        // 6. Spacer at bottom
        // ======================
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    // ======================
    // Add Allergy Dialog
    // ======================
    if (showAllergyDialog) {
        AlertDialog(
            onDismissRequest = { showAllergyDialog = false },
            title = { Text("Add Allergy") },
            text = {
                Column {
                    Text("Enter a food you're allergic to:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = newAllergy,
                        onValueChange = { newAllergy = it },
                        label = { Text("e.g. Peanuts, Dairy, Gluten") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (newAllergy.isNotBlank()) {
                            ProfileManager.addAllergy(newAllergy.trim())
                            newAllergy = ""
                            showAllergyDialog = false
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        newAllergy = ""
                        showAllergyDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}