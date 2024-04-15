package com.example.mspaint.mainui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
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
    val lines = remember {
        mutableStateListOf<Line>()
    }
    val undoneLines = remember {
        mutableStateListOf<Line>()
    }

    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var showSlider by remember { mutableStateOf(false) }
    val onToggleSlider: (Boolean) -> Unit = { showSlider = it }

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
                        Canvas(
                                modifier = Modifier
                                    .size(width = 350.dp, height = 500.dp)
                                    .background(color = Color.White)
                                    .pointerInput(true) {
                                        detectDragGestures { change,
                                                             dragAmount ->
                                            change.consume()

                                            val line = Line(
                                                start = change.position - dragAmount,
                                                end = change.position
                                            )
                                            lines.add(line)
                                        }
                                    }
                                )
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
                                valueRange = 4f..20f,

                                )
                            Text(
                                text = sliderPosition.toString()

                            )
                            pencilWidth = sliderPosition
                        }
                    )

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
                            onToggleSlider
                        )
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