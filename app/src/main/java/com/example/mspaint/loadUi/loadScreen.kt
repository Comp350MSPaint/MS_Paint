package com.example.mspaint.loadUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.navigation.compose.rememberNavController
import com.example.mspaint.R
import com.example.mspaint.Screen

@Composable
fun LoadScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    )
    {
        Column(modifier = Modifier
            .padding(10.dp)
            .align(Alignment.TopCenter),
           // verticalArrangement = Arrangement.Center,
          //  horizontalAlignment = Alignment.CenterHorizontally
        ){
            val rowModifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 5.dp)

            val columnModifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(4.dp)

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = rowModifier
            ) {
                Image(
                    painter = painterResource(R.drawable.save_select_title),
                    contentDescription = "title",
                    modifier = Modifier
                        .offset(y = 10.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = rowModifier
            ) {
                Box(
                    modifier = columnModifier

                ) {
                    Button(
                        onClick = { },//TODO: fill in route with canvas you hope to load.
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                            //.size(width = 150.dp, height = 150.dp)
                           // .offset(x = -10.dp, y = 60.dp)
                    ) {}
                    Image(
                        painter = painterResource(R.drawable.empty_file),//TODO: change the image to the canvas preview if we have one.
                        contentDescription = "NEW",
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.Center)
                           // .size(width = 150.dp, height = 150.dp)
                            //.offset(x = -10.dp, y = 60.dp)
                    )
                }
                Box(
                    modifier = columnModifier

                ) {
                    Button(
                        onClick = { },//TODO: fill in route with canvas you hope to load.
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                           // .size(width = 150.dp, height = 150.dp)
                            //.offset(x = 10.dp, y = 60.dp)
                    ) {}
                    Image(
                        painter = painterResource(R.drawable.empty_file),//TODO: change the image to the canvas preview if we have one.
                        contentDescription = "NEW",
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.Center)
                            //.size(width = 150.dp, height = 150.dp)
                           // .offset(x = 10.dp, y = 60.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = rowModifier
            ) {
                Box(
                    modifier = columnModifier

                ) {
                    Button(
                        onClick = { },//TODO: fill in route with canvas you hope to load.
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                            //.size(width = 150.dp, height = 150.dp)
                            //.offset(x = -10.dp, y = 90.dp)
                    ) {}
                    Image(
                        painter = painterResource(R.drawable.empty_file),//TODO: change the image to the canvas preview if we have one.
                        contentDescription = "NEW",
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.Center)
                           // .size(width = 150.dp, height = 150.dp)
                            //.offset(x = -10.dp, y = 90.dp)
                    )
                }
                Box(
                    modifier = columnModifier

                ) {
                    Button(
                        onClick = { },//TODO: fill in route with canvas you hope to load.
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                           // .size(width = 150.dp, height = 150.dp)
                            //.offset(x = 10.dp, y = 90.dp)
                    ) {}
                    Image(
                        painter = painterResource(R.drawable.empty_file),//TODO: change the image to the canvas preview if we have one.
                        contentDescription = "NEW",
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.Center)
                           // .size(width = 150.dp, height = 150.dp)
                           // .offset(x = 10.dp, y = 90.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = rowModifier
            ) {
                Box(
                    modifier = columnModifier

                ) {
                    Button(
                        onClick = { },//TODO: fill in route with canvas you hope to load.
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                          //  .size(width = 150.dp, height = 150.dp)
                            //.offset(x = -10.dp, y = 120.dp)
                    ) {}
                    Image(
                        painter = painterResource(R.drawable.empty_file),//TODO: change the image to the canvas preview if we have one.
                        contentDescription = "NEW",
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.Center)
                           // .size(width = 150.dp, height = 150.dp)
                           // .offset(x = -10.dp, y = 120.dp)
                    )
                }
                Box(
                    modifier = columnModifier

                ) {
                    Button(
                        onClick = { },//TODO: fill in route with canvas you hope to load.
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxSize()
                           // .size(width = 150.dp, height = 150.dp)
                           // .offset(x = 10.dp, y = 120.dp)
                    ) {}
                    Image(
                        painter = painterResource(R.drawable.empty_file),//TODO: change the image to the canvas preview if we have one.
                        contentDescription = "NEW",
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .align(Alignment.Center)
                            //.size(width = 150.dp, height = 150.dp)
                           // .offset(x = 10.dp, y = 120.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
                    .padding(2.dp)

            ) {
                Box() {
                    Button(
                        onClick = { navController.navigate(route = Screen.mainMenuScreen.route) },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .fillMaxHeight()
                        //.size(width = 80.dp, height = 100.dp)
                        //.offset(x = -30.dp, y = 160.dp)
                    ) {}
                    Image(
                        painter = painterResource(R.drawable.save_select_back),
                        contentDescription = "NEW",
                        //contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                        // .size(width = 80.dp, height = 100.dp)
                        // .offset(x = -30.dp, y = 160.dp)
                    )
                }
            }

        }//Column of all 6 save slots.

    }//Box(whole screen) end
}

@Preview
@Composable
fun MainMenuScreenPreview() {
    LoadScreen(navController = rememberNavController())
}