package com.example.mspaint.mainui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mspaint.R
import com.example.mspaint.canvasObjectData.hue
import com.example.mspaint.ui.theme.Green
import com.example.mspaint.ui.theme.Orange
import com.example.mspaint.ui.theme.Red
import com.example.mspaint.ui.theme.Yellow

@Composable
fun ShapesFunc (
    onToggleTriangle: (Boolean) -> Unit,
    onToggleSquare: (Boolean) -> Unit,
    onToggleCircle: (Boolean) -> Unit,
    onToggleLine: (Boolean) -> Unit,

    slider: @Composable () -> Unit
    ) {
    var triangleToggled by remember { mutableStateOf(false) }
    var squareToggled by remember { mutableStateOf(false) }
    var circleToggled by remember { mutableStateOf(false) }
    var lineToggled by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.background(Color.Black)
            .fillMaxSize()
            .background(Color.Yellow)
            .border(width = 3.dp, color = Color.Black)
    ){
        Row(
            modifier = Modifier

        ){
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(true)
                        onToggleSquare(false)
                        onToggleCircle(false)
                        onToggleLine(false)
                        triangleToggled = true
                        squareToggled = false
                        circleToggled = false
                        lineToggled = false
                    },

                    shape = RectangleShape,
                    //colors = ButtonDefaults.buttonColors(Red),
                    modifier = Modifier
                        .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black)
                )
                {


                }
                Image(
                    painter = painterResource(R.drawable.triangle),
                    contentDescription = "linee",
                    modifier = Modifier
                            .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black),
                contentScale = ContentScale.FillBounds // Adjust cont
                )
                if (triangleToggled){
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center)
                        .background(Color.Yellow)
                )}
            }
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(false)
                        onToggleSquare(false)
                        onToggleCircle(true)
                        onToggleLine(false)
                        triangleToggled = false
                        squareToggled = false
                        circleToggled = true
                        lineToggled = false
                    },

                    shape = RectangleShape,
                    //colors = ButtonDefaults.buttonColors(Red),
                    modifier = Modifier
                        .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black)
                )
                {

                }
                Image(
                    painter = painterResource(R.drawable.circle),
                    contentDescription = "linee",
                    modifier = Modifier
                        .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black),
                    contentScale = ContentScale.FillBounds // Adjust cont
                )
                if (circleToggled){
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                            .background(Color.Yellow)
                    )}

            }
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(false)
                        onToggleSquare(true)
                        onToggleCircle(false)
                        onToggleLine(false)
                        triangleToggled = false
                        squareToggled = true
                        circleToggled = false
                        lineToggled = false
                    },

                    shape = RectangleShape,
                    //colors = ButtonDefaults.buttonColors(Red),
                    modifier = Modifier
                        .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black)
                )
                {

                }
                Image(
                    painter = painterResource(R.drawable.square),
                    contentDescription = "linee",
                    modifier = Modifier
                        .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black),
                    contentScale = ContentScale.FillBounds // Adjust cont
                )
                if (squareToggled){
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                            .background(Color.Yellow)
                    )}

            }
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(false)
                        onToggleSquare(false)
                        onToggleCircle(false)
                        onToggleLine(true)
                        triangleToggled = false
                        squareToggled = false
                        circleToggled = false
                        lineToggled = true
                    },

                    shape = RectangleShape,
                    //colors = ButtonDefaults.buttonColors(Red),
                    modifier = Modifier
                        .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black)
                )
                {

                }
                Image(
                    painter = painterResource(R.drawable.linee),
                    contentDescription = "linee",
                    modifier = Modifier
                        .size(width = 61.dp, height = 60.dp)
                        .border(
                            width = 2.dp,
                            color = Color.Black),
                    contentScale = ContentScale.FillBounds // Adjust cont
                )
                if (lineToggled){
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                            .background(Color.Yellow)
                    )}

            }

        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally), // Adjust padding as needed
            //verticalAlignment = Alignment.Top // Align text to the top of the row
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterVertically)
            ) {
                slider()
            }
        }



    }
}


@Preview
@Composable
fun ShapesPreview() {
    MainScreen()
}