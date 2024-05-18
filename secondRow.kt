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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mspaint.R
import com.example.mspaint.tools.eraser
import com.example.mspaint.tools.pencil
import com.example.mspaint.ui.theme.Grey

@Composable
fun SecondRow(
    undo: ()-> Unit,
    redo: ()-> Unit,
    showSlider: Boolean,
    onToggleSlider: (Boolean) -> Unit,
    onToggleShapes: (Boolean) -> Unit,

    onPencilToolClick: () -> Unit,
    showShapes: Boolean
) {
    var toolSelected by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Grey)
            .padding(0.dp)
    ) {
        val reusableModifier = Modifier
            .fillMaxSize()
            .weight(1f)


        Box(
            modifier = reusableModifier
        ) {
            Button(
                onClick = { undo() },
                shape = RectangleShape,
                modifier = Modifier.size(width = 80.dp, height = 65.dp)
            ) {

            }
            Image(
                painter = painterResource(R.drawable.undo),
                contentDescription = "undo"
            )
        }
        Box(
            modifier = reusableModifier
        ) {
            Button(
                onClick = { redo() },
                shape = RectangleShape,
                modifier = Modifier.size(width = 80.dp, height = 65.dp)
            ) {

            }
            Image(
                painter = painterResource(R.drawable.redo),
                contentDescription = "redo"
            )
        }
        Box(
            modifier = reusableModifier
        ) {
            Button(
                onClick = { onToggleSlider(false)
                    onToggleShapes(false);
                    if (toolSelected) {
                        toolbarState = 0
                    }
                    else {

                    }
                },
                shape = RectangleShape,
                modifier = Modifier.size(width = 80.dp, height = 65.dp)
            ) {

            }
            //Image(
            //    painter = painterResource(R.drawable.pallet),
            //    contentDescription = "pallet"
            // )
        }
        Box(
            modifier = reusableModifier
        ) {
            Button(

                onClick = { pencil(); toolbarState= 5; toolSelected = true;onToggleSlider(true); onToggleShapes(false);},

                shape = RectangleShape,
                modifier = Modifier.size(width = 80.dp, height = 65.dp)
            ) {

            }
            //  Image(
            //      painter = painterResource(R.drawable.pencil),
            //      contentDescription = "pencil"
            //  )
        }
        Box(
            modifier = reusableModifier
        ) {
            Button(
                onClick = { eraser(); toolbarState = 3; toolSelected = true; onToggleSlider(true); onToggleShapes(false);},
                shape = RectangleShape,
                modifier = Modifier.size(width = 80.dp, height = 65.dp)
            ) {

            }
            //Image(
            //    painter = painterResource(R.drawable.eraser),
            //    contentDescription = "eraser"
            //)
        }
        Box(
            modifier = reusableModifier
        ) {
            Button(
                onClick = {pencil()},
                shape = RectangleShape,
                modifier = Modifier.size(width = 80.dp, height = 65.dp)
            ) {

            }
            Image(
                painter = painterResource(R.drawable.bucket),
                contentDescription = "bucket"
            )
        }
        Box(
            modifier = reusableModifier
        ) {
            Button(
                onClick = { onToggleShapes(true);onToggleSlider(false); toolbarState = 4},
                shape = RectangleShape,
                modifier = Modifier.size(width = 80.dp, height = 65.dp)
            ) {

            }
            // Image(
            //     painter = painterResource(R.drawable.shapes),
            //     contentDescription = "shape"
            // )
        }

    }
}

@Preview
@Composable
fun SecondRowPreview() {
    MainScreen()
}