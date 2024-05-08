package com.example.mspaint.mainui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.mspaint.canvasObjectData.hue
import com.example.mspaint.tools.restoreToHue
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
import com.example.mspaint.ui.theme.Grey


@Composable
fun PalletFunc (

) {
    Column(
        modifier = Modifier
            .padding(13.dp)
            .background(Grey)
            .height(100.dp)
    ){
        val colorButtonModifier : Modifier = Modifier
            .size(width = 42.dp,height = 38.dp)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Red; restoreToHue = hue; paletteState=0 },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Red),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Orange; restoreToHue = hue; paletteState = 1},
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Orange),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Yellow; restoreToHue = hue; paletteState = 2},
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Yellow),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Green; restoreToHue = hue; paletteState = 3},
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Green),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Aqua; restoreToHue = hue; paletteState=4 },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Aqua),
                    modifier = colorButtonModifier
                ) {

                }

            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = White; restoreToHue = hue; paletteState=5 },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(White),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Black; restoreToHue = hue; paletteState=6 },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Black),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Purple; restoreToHue = hue; paletteState=7 },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Purple),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Magenta; restoreToHue = hue; paletteState=8 },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Magenta),
                    modifier = colorButtonModifier
                ) {

                }

            }
            Box(
                modifier = Modifier
            ) {
                Button(
                    onClick = { hue = Blue; restoreToHue = hue; paletteState=9 },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Blue),
                    modifier = colorButtonModifier
                ) {

                }

            }

        }
    }
}

@Preview
@Composable
fun PalettePreview() {
    MainScreen(navController = rememberNavController())
}