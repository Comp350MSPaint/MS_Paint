package com.example.mspaint

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.mspaint.mainui.MainScreen
import com.example.mspaint.ui.theme.MSPaintTheme
import java.io.File

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.appContext = applicationContext
        setContent {
            MSPaintTheme {
                MainScreen()
            }
        }
    }
    companion object {
        lateinit var appContext: Context
    }

}