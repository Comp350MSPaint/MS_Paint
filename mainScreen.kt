package com.example.mspaint.mainui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mspaint.canvasObjectData.Line
import com.example.mspaint.canvasObjectData.pencilWidth
import com.example.mspaint.ui.theme.PureBlack

@Composable
fun MainScreen() {
    // Number of strokes
    var strokeCount by remember { mutableStateOf(0) }
    var tickCount by remember { mutableStateOf(0) }
    val tapCoordinates = remember { mutableStateListOf<Offset>() }

    // List of lines as mutable state
    val lines = remember { mutableStateListOf<Line>() }
    val undoneLines = remember {
        mutableStateListOf<Line>()
    }
    var lineEnd: Boolean = true

    var sliderPosition by remember { mutableFloatStateOf(0f) }

    var showSlider by remember { mutableStateOf(false) }

    // Define a callback to toggle the slider visibility
    val onToggleSlider: (Boolean) -> Unit = { showSlider = it }
    var isBucketToolSelected by remember { mutableStateOf(false) }
    var tapX by remember { mutableStateOf(0f) }
    var tapY by remember { mutableStateOf(0f) }

    var tapX2 by remember { mutableStateOf(0f) }
    var tapY2 by remember { mutableStateOf(0f) }
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)

        ) {
            Text(
                text = "coords: ($tapX, $tapY)",
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "\n    coords: ($tapX2, $tapY2)",
                modifier = Modifier.padding(16.dp)
            )
            // The actual canvas
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
                        Canvas(
                            modifier = Modifier
                                .size(width = 350.dp, height = 500.dp)
                                .background(color = Color.White)
                                .pointerInput(true) {
                                    detectTapGestures(
                                        onPress = { it ->
                                            if (tapX == 0f && tapY == 0f) {
                                                tapX = it.x
                                                tapY = it.y
                                            } else {
                                                tapX2 = it.x
                                                tapY2 = it.y
                                                lines.add(Line(start = Offset(tapX, tapY), end = Offset(tapX2, tapY2), color = Color.Black))
                                                tapX = 0f
                                                tapY = 0f
                                            }
                                        }
                                    )
                                }
                                .pointerInput(true) {
                                    detectDragGestures(
                                        onDragEnd = {
                                            strokeCount++ // Increment stroke count when drag gesture ends
                                        }
                                    ) { change,
                                        dragAmount ->
                                        change.consume()

                                        val line = Line(
                                            start = change.position - dragAmount,
                                            end = change.position
                                        )
                                        lines.add(line)
                                        tickCount++
                                    }
                                }
                        ) { // Creates the actual drawing. drawLine function is a part of Jetpack Compose
                            lines.forEach { line ->

                                    // Draw lines only if there are any
                                    drawLine(
                                        color = line.color,
                                        start = line.start,
                                        end = line.end,
                                        strokeWidth = 2.dp.toPx(), // Adjust stroke width as needed
                                        cap = StrokeCap.Round
                                    )



                            }
                        }    }
                }
            }


            // The toolbar
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = PureBlack, shape = RectangleShape)
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                // Rows
                Column {
                    var hide: Boolean = true
                    // First row
                    hide = firstRow(
                        showSlider,
                        slider = {
                            Slider(
                                value = sliderPosition,
                                onValueChange = { sliderPosition = it },
                                colors = SliderDefaults.colors(
                                    thumbColor = MaterialTheme.colorScheme.secondary,
                                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                                    inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                                ),
                                steps = 5,
                                valueRange = 4f..20f
                            )
                            Text(
                                text = sliderPosition.toString()

                            )
                            pencilWidth = sliderPosition
                        }
                    )

                    // Second row
                    if (!hide) {
                        SecondRow(
                            undo = {
                                if (lines.isNotEmpty()) {
                                    val lastLine = lines.last()
                                    lines.remove(lastLine)
                                    undoneLines.add(lastLine)
                                }
                            },
                            redo = {
                                if (undoneLines.isNotEmpty()) {
                                    val undoneLine = undoneLines.last()
                                    undoneLines.remove(undoneLine)
                                    lines.add(undoneLine)

                                }
                            },
                            showSlider,
                            onToggleSlider,
                            onBucketToolClick = { isBucketToolSelected = !isBucketToolSelected }

                        )
                    }
                }
            }
        }
    }
}