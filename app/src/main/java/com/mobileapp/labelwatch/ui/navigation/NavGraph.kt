package com.mobileapp.labelwatch.ui.navigation

import androidx.compose.runtime.Composable
import com.mobileapp.labelwatch.ui.screens.MainScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobileapp.labelwatch.ui.screens.results.ResultScreen



@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main"
    ){
        composable("main") {
            MainScreen(navController)
        }
        composable("results") {
            ResultScreen(navController)
        }
    }
}