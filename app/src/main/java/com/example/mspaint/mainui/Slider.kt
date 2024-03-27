package com.example.mspaint.mainui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.mspaint.canvasObjectData.pencilWidth

@Composable
fun SliderFunc() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    pencilWidth = 2f

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.secondary,
            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        steps = 5,
        valueRange = 2f..20f,

        )
    Text(
        text = sliderPosition.toString()

    )
    pencilWidth = sliderPosition
}


@Preview
@Composable
fun SliderPreview() {
    SliderFunc()
}
