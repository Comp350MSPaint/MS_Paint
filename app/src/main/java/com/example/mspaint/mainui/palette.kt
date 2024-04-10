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
import com.example.mspaint.tools.pencil

@Composable
fun PalletFunc() {
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
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFFF00)),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFA500)),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color(0xFF00FF00)),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Cyan),
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
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.White),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color(0xFF800080)),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color(0xFFE6E6FA)),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { pencil() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    modifier = Modifier
                        .size(width = 47.dp, height = 50.dp)
                ) {

                }

            }

        }
    }
}