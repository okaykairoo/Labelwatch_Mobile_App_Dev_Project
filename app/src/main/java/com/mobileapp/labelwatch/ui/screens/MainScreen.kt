package com.mobileapp.labelwatch.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.mobileapp.labelwatch.ui.screens.history.HistoryScreen
import com.mobileapp.labelwatch.ui.screens.profile.ProfileScreen
import androidx.compose.material.icons.filled.Build
import com.mobileapp.labelwatch.ui.screens.MatcherTestScreen
import androidx.navigation.NavHostController


@Composable
fun MainScreen(
    navController: NavHostController
) {


    var selectedTab by remember { mutableStateOf(0) }



    Scaffold(
        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.CameraAlt, contentDescription = "Scan") },
                    label = { Text("Scan") }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.History, contentDescription = "History") },
                    label = { Text("History") }
                )

                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") }
                )

                //NavigationBarItem(
                    //selected = selectedTab ==3,
                    //onClick = { selectedTab = 3},
                    //icon = {
                        //Icon(
                           // Icons.Default.Build,
                           // contentDescription = "Developer Test"
                       // )
                   // },
                    //label = {
                        //Text("Dev")
                    //}
                //)
            }
        }
    ) { padding ->

        Box(modifier = Modifier.padding(padding)) {

            when (selectedTab) {
                0 -> ScanScreen(navController)
                1 -> HistoryScreen()
                2 -> ProfileScreen()
                //3 -> MatcherTestScreen()
            }
        }
    }
}