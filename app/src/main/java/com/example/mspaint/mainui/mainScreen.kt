package com.example.mspaint.mainui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    // list of lines
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier

        ) {
            //the actual canvas
            DrawScreen()
            // the toolbar
            Box(
                modifier = Modifier
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