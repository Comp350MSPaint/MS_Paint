package com.example.mspaint.mainui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import com.example.mspaint.canvasObjectData.Line
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun DrawScreen() {
    val lines = remember {
        mutableStateListOf<Line>()
    }
    Canvas(
// sets up the canvas
        modifier = Modifier
            //.fillMaxSize()
            .size(width = 350.dp, height = 500.dp)
            .background(color = Color.White) // Set the eraser color same to this and set the background color by "system setting".
            .pointerInput(true) {
                detectDragGestures { change, dragAmount ->
                    change.consume()

                    val line = Line(
                        start = change.position - dragAmount,
                        end = change.position
                    )
                    lines.add(line)
                }
            }
    ) // creates the actual drawing. drawLine function is a part of Jetpack Compose
    {
        lines.forEach { line ->
            drawLine(
                color = line.color,
                start = line.start,
                end = line.end,
                strokeWidth = line.strokeWidth.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}