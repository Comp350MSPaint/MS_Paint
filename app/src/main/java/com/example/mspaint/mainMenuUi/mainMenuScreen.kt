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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mspaint.R
import com.example.mspaint.Screen
import com.example.mspaint.mainui.MainScreen
import com.example.mspaint.ui.theme.Black

@Composable
fun MainMenuScreen(
    navController: NavController
) {
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
                painter = painterResource(R.drawable.title_menu),
                contentDescription = "title",
                        modifier = Modifier
                            .offset(y = 10.dp)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = { navController.navigate(route = Screen.mainScreen.route) },//"NEW": Goto mainScreen.
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 60.dp)
                ) {}
                Image(
                    painter = painterResource(R.drawable.new_menu),
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
                    onClick = { navController.navigate(route = Screen.loadScreen.route) },//TODO:"LOAD"
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier
                        .size(width = 310.dp, height = 85.dp)
                        .offset(y = 100.dp)
                ) {}
                Image(
                    painter = painterResource(R.drawable.load_menu),
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
                    painter = painterResource(R.drawable.share_menu),
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
                    painter = painterResource(R.drawable.options_menu),
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
    MainMenuScreen(navController = rememberNavController())
}

