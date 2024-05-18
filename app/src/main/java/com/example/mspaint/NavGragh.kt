package com.example.mspaint

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mspaint.loadUi.LoadScreen
import com.example.mspaint.mainMenuUi.MainMenuScreen
import com.example.mspaint.mainui.MainScreen

@Composable
fun SetupNavGragh(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.mainMenuScreen.route
    ){
        composable(
            route = Screen.mainMenuScreen.route
        ) {
            MainMenuScreen(navController)
        }
        composable(
            route = Screen.mainScreen.route
        ) {
            MainScreen(navController)
        }
        composable(
            route = Screen.loadScreen.route
        ) {
            LoadScreen(navController)
        }
    }
}