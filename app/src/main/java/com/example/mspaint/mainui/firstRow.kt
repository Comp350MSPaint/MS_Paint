package com.example.mspaint.mainui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.mspaint.R
import com.example.mspaint.tools.pencil
import com.example.mspaint.ui.theme.Grey

@Composable
fun firstRow(
    showSlider: Boolean,
    showShapes: Boolean,
    onToggleTriangle: (Boolean) -> Unit,
    onToggleSquare: (Boolean) -> Unit,
    onToggleCircle: (Boolean) -> Unit,
    onToggleLine: (Boolean) -> Unit,
    slider: @Composable () -> Unit,
    save: ()->Unit,
): Boolean {
    var hidden by remember{ mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Grey)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(width = 53.dp, height = 65.dp)
            ) {
                OutlinedButton(
                    onClick = { save()},
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RectangleShape,
                    modifier = Modifier.size(width = 50.dp, height = 65.dp)
                ) {

                }
                Image(
                    painter = painterResource(R.drawable.options),
                    contentDescription = "options",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                )

            }
        }
        Box(
            modifier = Modifier

                .weight(5f)
                .align(Alignment.CenterVertically)
        ) {
            if (showSlider) {
                slider()
            }
            else if (showShapes){
                ShapesFunc(onToggleTriangle, onToggleSquare, onToggleCircle, onToggleLine, slider)
            }
            else{
                PalletFunc()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    PaletteImages(
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                        paletteState
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(width = 53.dp, height = 65.dp)
            )
            {

                Button(
                    onClick = { hidden = !hidden },
                    shape = RectangleShape,
                    modifier = Modifier.size(width = 53.dp, height = 65.dp)
                ) {

                }
                Image(
                    painter = painterResource(R.drawable.updown),
                    contentDescription = "updown",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                )

            }

        }
    }
    return hidden
}


@Preview
@Composable
fun FirstRowPreview() {
    MainScreen(navController = rememberNavController())
}

