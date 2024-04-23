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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mspaint.canvasObjectData.PathProperties
import com.example.mspaint.canvasObjectData.hue
import com.example.mspaint.canvasObjectData.pencilWidth
import com.example.mspaint.ui.theme.PureBlack

var toolbarState by mutableStateOf(0)
@Composable
fun MainScreen() {
    // list of lines
    val paths = remember {
        mutableStateListOf<Pair<Path,PathProperties>>()
    }
    val tempPath = remember {
        mutableStateListOf<Pair<Path,PathProperties>>()
    }
    val undonePaths = remember {
        mutableStateListOf<Pair<Path,PathProperties>>()
    }

    var sliderPosition by remember { mutableFloatStateOf(0f) }

    var showSlider by remember { mutableStateOf(false) }

    // Define a callback to toggle the slider visibility
    val onToggleSlider: (Boolean) -> Unit = { showSlider = it }
    var isShapeToolSelected by remember { mutableStateOf(false) }
    var isPencilToolSelected by remember { mutableStateOf(false) }

    val onBucketToolClick: (Boolean)-> Unit = {isShapeToolSelected = it }
    var hide: Boolean = true
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
            //the actual canvas
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = PureBlack, shape = RectangleShape)
                    .size(
                        width = 400.dp,
                        height = 645.dp
                    )//The size of this box add the size of tool bar fill the whole screen,
                    .align(Alignment.TopCenter)
                    .padding(5.dp)
            ) {
                Column(modifier = Modifier
                    .align(Alignment.Center)
                ) {
                    Row(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                    ) {
                        var currentPath by remember {mutableStateOf(Path())}
                        var currentPathProperties by remember {mutableStateOf(PathProperties())}
                        var finalProperty: PathProperties

                        Canvas(
                            // sets up the canvas
                            modifier = Modifier
                                .size(width = 350.dp, height = 500.dp)
                                .background(color = Color.White)
                                .pointerInput(true) {
                                    detectDragGestures(
                                        onDrag = { change, dragAmount ->
                                            change.consume()
                                            if(!isShapeToolSelected){
                                            currentPath.lineTo(change.position.x, change.position.y)
                                            }
                                            // Update the canvas in real-time
                                            tempPath.add(Pair(currentPath, currentPathProperties))
                                        },
                                        onDragStart = {
                                            currentPath = Path().apply {
                                                moveTo(it.x, it.y)
                                            }
                                            currentPathProperties = PathProperties(
                                                strokeWidth = sliderPosition,
                                                color = hue
                                            )
                                        },
                                        onDragEnd = {
                                            finalProperty = PathProperties(currentPathProperties)
                                            paths.add(Pair(currentPath, finalProperty))
                                            tempPath.clear()
                                        }
                                    )
                                }
                                .pointerInput(true) {
                                    detectTapGestures(
                                        onPress = { it ->
                                            if (tapX == 0f && tapY == 0f) {
                                                if (isShapeToolSelected) {
                                                    tapX = it.x
                                                    tapY = it.y
                                                }
                                            } else {
                                                if (isShapeToolSelected) {
                                                    tapX2 = it.x
                                                    tapY2 = it.y
                                                }
                                                if (isShapeToolSelected) {
                                                    paths.add(
                                                        Pair(
                                                            Path().apply {
                                                                moveTo(tapX, tapY)
                                                                lineTo(tapX2, tapY2)
                                                            },
                                                            PathProperties(
                                                                color = hue,
                                                                strokeWidth = sliderPosition
                                                            )))                                                }

                                                tapX = 0f
                                                tapY = 0f
                                            }
                                        }
                                    )
                                }
                        ) {
                            // draw the completed paths
                            paths.forEach { (path, property) ->
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
                            // draw the current path in real-time
                            tempPath.forEach { (path, property) ->
                                drawPath(
                                    color = currentPathProperties.color,
                                    path = currentPath,
                                    style = Stroke(
                                        width = currentPathProperties.strokeWidth,
                                        cap = currentPathProperties.strokeCap,
                                        join = currentPathProperties.strokeJoin
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
                            onToggleSlider,
                            onBucketToolClick,
                            onPencilToolClick = {isPencilToolSelected = !isPencilToolSelected}
                        )
                    }
                }
            }

        }
    }

    if (!hide) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 25.dp)
        ) {
            ToolbarUI(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                toolbarState
            )
        }
    }
}



@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}