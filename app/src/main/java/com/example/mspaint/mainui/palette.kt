package com.example.mspaint.mainui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.mspaint.canvasObjectData.hue
import com.example.mspaint.tools.pencil
import com.example.mspaint.ui.theme.Aqua
import com.example.mspaint.ui.theme.Black
import com.example.mspaint.ui.theme.Blue
import com.example.mspaint.ui.theme.Green
import com.example.mspaint.ui.theme.Magenta
import com.example.mspaint.ui.theme.Orange
import com.example.mspaint.ui.theme.Purple
import com.example.mspaint.ui.theme.Red
import com.example.mspaint.ui.theme.White
import com.example.mspaint.ui.theme.Yellow

@Composable
fun PalletFunc (

) {
    Column(
        modifier = Modifier.background(Color.Black)
            .height(100.dp)
            .width(237.dp)
            .background(Color.Black)
            .border(width = 3.dp, color = Color.Black)
    ){
        Row(
            modifier = Modifier
                .width(237.dp)
                .height(50.dp)
        ){
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Red },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Red),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Yellow},
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Yellow),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Orange },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Orange),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Green },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Green),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Aqua },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Aqua),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
        }
        Row(
            modifier = Modifier
                .width(237.dp)
                .height(50.dp)
        ){
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = White },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(White),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Black },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Black),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Purple },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Purple),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Magenta },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Magenta),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Blue },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Blue),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }

        }
    }
}