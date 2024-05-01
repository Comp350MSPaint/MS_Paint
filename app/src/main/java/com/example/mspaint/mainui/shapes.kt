package com.example.mspaint.mainui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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


    ) {
    Column(
        modifier = Modifier.background(Color.Black)
            .height(100.dp)
            .width(245.dp)
            .background(Color.Yellow)
            .border(width = 3.dp, color = Color.Black)
    ){
        Row(
            modifier = Modifier
                .width(245.dp)
                .height(75.dp)
        ){
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(true)
                        onToggleSquare(false)
                        onToggleCircle(false)
                        onToggleLine(false)},

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

            }
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(false)
                        onToggleSquare(false)
                        onToggleCircle(true)
                        onToggleLine(false)},

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

            }
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(false)
                        onToggleSquare(true)
                        onToggleCircle(false)
                        onToggleLine(false)},

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

            }
            Box(
                modifier = Modifier
            ) {

                Button(
                    onClick = {onToggleTriangle(false)
                        onToggleSquare(false)
                        onToggleCircle(false)
                        onToggleLine(true)},

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

            }

        }
        Row(
            modifier = Modifier
                .width(245.dp)
                .height(40.dp)
                .padding(start = 16.dp), // Adjust padding as needed
            verticalAlignment = Alignment.Top // Align text to the top of the row
        ) {
            Text(
                text = "t \n",
                color = Color.Black,
                fontSize = 20.sp, // Adjust the text size here
                modifier = Modifier
                    .fillMaxWidth() // Fill the entire width of the row
                    .alignByBaseline() // Align text to the baseline of the row
            )
        }



    }
}