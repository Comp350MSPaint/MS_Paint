package com.example.mspaint

sealed class Screen(val route: String) {
    object mainMenuScreen: Screen(route = "main_menu_screen")
    object mainScreen: Screen(route = "canvas_screen")
    object loadScreen: Screen(route = "load_screen")
}