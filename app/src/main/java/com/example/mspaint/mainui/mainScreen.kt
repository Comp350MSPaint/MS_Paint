package com.example.mspaint.mainui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mspaint.ui.theme.PureBlack

@Composable
fun MainScreen() {
    // list of lines
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)

        ) {
            //the actual canvas
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = PureBlack, shape = RectangleShape)
                    .size(width = 400.dp, height = 645.dp)//The size of this box add the size of tool bar fill the whole screen,
                    .align(Alignment.TopCenter)
                    .padding(5.dp)
            ) {
                Column(modifier = Modifier
                    .align(Alignment.Center)
                ) {
                    Row(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                    ) {
                        DrawScreen()
                    }
                }
            }
            // the toolbar
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = PureBlack, shape = RectangleShape)
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                // rows
                Column {
                    var hide: Boolean = true
                    // first row
                    hide = firstRow()

                    // second row
                    if (!hide) {
                        SecondRow()
                    }
                }
            }

        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}