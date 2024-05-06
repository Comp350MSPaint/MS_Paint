package com.example.mspaint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mspaint.mainui.MainScreen
import com.example.mspaint.ui.theme.MSPaintTheme
import java.security.AccessController

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MSPaintTheme {
                //MainScreen()

                navController = rememberNavController()
                SetupNavGragh(navController = navController)
            }
        }
    }
}