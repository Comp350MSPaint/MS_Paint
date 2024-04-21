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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mspaint.canvasObjectData.PathProperties
import com.example.mspaint.canvasObjectData.hue
import com.example.mspaint.canvasObjectData.pencilWidth
import com.example.mspaint.ui.theme.PureBlack

@Composable
fun MainScreen() {
    // list of lines
    val paths = remember {
        mutableStateListOf<Pair<Path,PathProperties>>()
    }
    val undonePaths = remember {
        mutableStateListOf<Pair<Path,PathProperties>>()
    }

    var sliderPosition by remember { mutableFloatStateOf(0f) }

    var showSlider by remember { mutableStateOf(false) }

    // Define a callback to toggle the slider visibility
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
                        var currentPath = Path()
                        var currentPathProperties = PathProperties(
                            color = hue,
                            strokeWidth = pencilWidth,
                            strokeCap = StrokeCap.Round
                        )
                        Canvas(
                                // sets up the canvas
                                modifier = Modifier
                                    .size(width = 350.dp, height = 500.dp)
                                    .background(color = Color.White)
                                    .pointerInput(true) {
                                        detectDragGestures(
                                            onDrag = { change, dragAmount ->
                                                change.consume()

                                                currentPath.lineTo(change.position.x, change.position.y)
                                            },
                                            onDragStart = {
                                                currentPath = Path().apply {
                                                    moveTo(it.x, it.y)
                                                }
                                            },
                                            onDragEnd = {
                                                paths.add(Pair(currentPath, currentPathProperties))
                                            }
                                        )

                                    }
                                ) // creates the actual drawing. drawLine function is a part of Jetpack Compose
                        {
                            paths.forEach {
                                (path,property)->
                                drawPath(
                                    color = property.color,
                                    path = path,
                                    style = Stroke(
                                        width = property.strokeWidth,
                                        cap = property.strokeCap,
                                        join = property.strokeJoin
                                    )
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
                    // first row
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

                    // second row
                    if (!hide) {
                        SecondRow(
                            undo = {
                                if (paths.isNotEmpty()) {
                                    val lastLine = paths.last()
                                    paths.remove(lastLine)
                                    undonePaths.add(lastLine)
                                }
                            },
                            redo = {
                                if (undonePaths.isNotEmpty()) {
                                    val undoneLine = undonePaths.last()
                                    undonePaths.remove(undoneLine)
                                    paths.add(undoneLine)
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