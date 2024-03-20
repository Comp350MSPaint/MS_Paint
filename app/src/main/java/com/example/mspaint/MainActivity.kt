package com.example.mspaint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mspaint.mainui.MainScreen
import com.example.mspaint.ui.theme.MSPaintTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MSPaintTheme {
                MainScreen()
            }
        }
    }
}