package com.example.mspaint.mainMenuUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mspaint.R
import com.example.mspaint.mainui.MainScreen
import com.example.mspaint.ui.theme.Black

@Composable
fun MainMenuScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
        )
    {
        Column(modifier = Modifier
            .padding(40.dp)
            .align(Alignment.TopCenter)
        ){
            Image(
                painter = painterResource(R.drawable.ms_testtitle1),
                contentDescription = "title",
                        modifier = Modifier
                            .offset(y = 10.dp)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {  },//TODO:"NEW"
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 60.dp)
                ) {}
                Image(
                    painter = painterResource(R.drawable.ms_mainmenubuttons_1),
                    contentDescription = "NEW",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 60.dp)
                    )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {  },//TODO:"LOAD"
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 100.dp)
                ) {}
                Image(
                    painter = painterResource(R.drawable.ms_mainmenubuttons_2),
                    contentDescription = "LOAD",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 100.dp)
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {  },//TODO:"SHARE"
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 140.dp)
                ) {}
                Image(
                    painter = painterResource(R.drawable.ms_mainmenubuttons_3),
                    contentDescription = "SHARE",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 140.dp)
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {  },//TODO:"OPTIONS"
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 180.dp)
                ) {}
                Image(
                    painter = painterResource(R.drawable.ms_mainmenubuttons_4),
                    contentDescription = "OPTIONS",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 180.dp)
                )
            }

        }//All 4 images inside this column.

    }//Box(whole screen) end
}

@Preview
@Composable
fun MainMenuScreenPreview() {
    MainMenuScreen()
}

