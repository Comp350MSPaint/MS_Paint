package com.example.mspaint.mainui

import android.content.res.Resources
import android.graphics.Bitmap
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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mspaint.R
import com.example.mspaint.MainActivity
import com.example.mspaint.canvasObjectData.PathProperties
import com.example.mspaint.canvasObjectData.hue
import com.example.mspaint.canvasObjectData.pencilWidth
import com.example.mspaint.tools.saveToDisk
import com.example.mspaint.ui.theme.PureBlack
import kotlin.math.cos
import kotlin.math.sin

var toolbarState by mutableIntStateOf(0)
var paletteState by mutableIntStateOf(0)
@Composable
fun MainScreen(
    navController: NavController
) {

    val canvasWidth: Dp = 350.dp
    val canvasHeight: Dp = 500.dp

    val drawScope = CanvasDrawScope()
    val size = Size(350.dpToFloat(),500.dpToFloat())
    val bitmap = ImageBitmap(size.width.toInt(),size.height.toInt())
    val canvas = androidx.compose.ui.graphics.Canvas(bitmap)


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
    var showShapes by remember { mutableStateOf(false) }
    var showTriangle by remember { mutableStateOf(false) }
    var showSquare by remember { mutableStateOf(false) }
    var showCircle by remember { mutableStateOf(false) }
    var showLine by remember { mutableStateOf(false) }


    // Define a callback to toggle the slider visibility
    val onToggleSlider: (Boolean) -> Unit = { showSlider = it }
    val onToggleShapes: (Boolean) -> Unit = { showShapes = it }
    val onToggleTriangle: (Boolean) -> Unit = { showTriangle = it }
    val onToggleSquare: (Boolean) -> Unit = { showSquare = it }
    val onToggleCircle: (Boolean) -> Unit = { showCircle = it }
    val onToggleLine: (Boolean) -> Unit = { showLine = it }


    var isShapeToolSelected by remember { mutableStateOf(false) }
    var isPencilToolSelected by remember { mutableStateOf(false) }

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
                                .size(canvasWidth, canvasHeight)
                                .background(color = Color.White)
                                .pointerInput(true) {
                                    detectDragGestures(
                                        onDrag = { change, dragAmount ->
                                            change.consume()
                                            if(!showShapes){
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
                                            if (showCircle && showShapes){
                                                if (tapX == 0f && tapY == 0f) {
                                                    if (showCircle && showShapes) {
                                                        tapX = it.x
                                                        tapY = it.y
                                                    }
                                                } else {
                                                    if (showCircle && showShapes) {
                                                        // Calculate the center and radius of the circle
                                                        val circleCenterX = (tapX + it.x) / 2
                                                        val circleCenterY = (tapY + it.y) / 2
                                                        val radius = Math.abs(tapX - it.x) / 2

                                                        val circlePath = Path().apply {
                                                            moveTo(circleCenterX + radius, circleCenterY) // Move to the starting point
                                                            for (angle in 0..360 step 10) { // Draw small line segments to approximate the circle
                                                                val x = circleCenterX + radius * cos(Math.toRadians(angle.toDouble())).toFloat()
                                                                val y = circleCenterY + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
                                                                lineTo(x, y)
                                                            }
                                                            close() // Close the path to complete the circle
                                                        }

// Add the circle path to the paths list
                                                        paths.add(
                                                            Pair(
                                                                circlePath,
                                                                PathProperties(
                                                                    color = hue,
                                                                    strokeWidth = sliderPosition
                                                                )
                                                            )
                                                        )
                                                    }
                                                    tapX = 0f
                                                    tapY = 0f
                                                }
                                            }
                                            else if (showTriangle && showShapes) {
                                                if (tapX == 0f && tapY == 0f) {
                                                    if (showShapes) {
                                                        tapX = it.x
                                                        tapY = it.y
                                                    }
                                                } else {
                                                    if (showShapes) {
                                                        // Calculate the vertices of the triangle
                                                        val vertex1X = tapX
                                                        val vertex1Y = tapY
                                                        val vertex2X = it.x
                                                        val vertex2Y = it.y
                                                        val centerX = (vertex1X + vertex2X) / 2
                                                        val centerY = (vertex1Y + vertex2Y) / 2
                                                        val height = Math.sqrt(Math.pow((vertex2X - vertex1X).toDouble(), 2.0) + Math.pow((vertex2Y - vertex1Y).toDouble(), 2.0)) * Math.sqrt(3.0) / 2
                                                        val halfBase = Math.sqrt(Math.pow((vertex2X - vertex1X).toDouble(), 2.0) + Math.pow((vertex2Y - vertex1Y).toDouble(), 2.0)) / 2

                                                        val trianglePath = Path().apply {
                                                            moveTo(centerX.toFloat(), (centerY - height / 2).toFloat())
                                                            lineTo((centerX + halfBase).toFloat(), (centerY + height / 2).toFloat())
                                                            lineTo((centerX - halfBase).toFloat(), (centerY + height / 2).toFloat())
                                                            close() // Close the path to complete the triangle
                                                        }

                                                        // Add the triangle path to the paths list
                                                        paths.add(
                                                            Pair(
                                                                trianglePath,
                                                                PathProperties(
                                                                    color = hue,
                                                                    strokeWidth = sliderPosition
                                                                )
                                                            )
                                                        )
                                                    }
                                                    tapX = 0f
                                                    tapY = 0f
                                                }

                                            }
                                            if (showSquare && showShapes) {
                                                if (tapX == 0f && tapY == 0f) {
                                                    // Store the first tap position as the starting point of the square
                                                    tapX = it.x
                                                    tapY = it.y
                                                } else {
                                                    // Calculate the center position of the square
                                                    val centerX = (tapX + it.x) / 2
                                                    val centerY = (tapY + it.y) / 2

                                                    // Calculate half the width and height of the square
                                                    val halfWidth = Math.abs(it.x - tapX) / 2
                                                    val halfHeight = Math.abs(it.y - tapY) / 2

                                                    // Calculate the actual end points of the square based on the center position
                                                    val startX = centerX - halfWidth
                                                    val startY = centerY - halfHeight
                                                    val endX = centerX + halfWidth
                                                    val endY = centerY + halfHeight

                                                    // Create the square path
                                                    val squarePath = Path().apply {
                                                        moveTo(startX, startY)
                                                        lineTo(endX, startY)
                                                        lineTo(endX, endY)
                                                        lineTo(startX, endY)
                                                        close() // Close the path to complete the square
                                                    }

                                                    // Add the square path to the paths list
                                                    paths.add(
                                                        Pair(
                                                            squarePath,
                                                            PathProperties(
                                                                color = hue,
                                                                strokeWidth = sliderPosition
                                                            )
                                                        )
                                                    )

                                                    // Reset tap positions for next square
                                                    tapX = 0f
                                                    tapY = 0f
                                                }



                                            }
                                            if (showLine && showShapes) {
                                                if (tapX == 0f && tapY == 0f) {
                                                    // Store the first tap position as the starting point of the line
                                                    tapX = it.x
                                                    tapY = it.y
                                                } else {
                                                    // Store the second tap position as the ending point of the line
                                                    tapX2 = it.x
                                                    tapY2 = it.y
                                                    // Draw the line
                                                    paths.add(
                                                        Pair(
                                                            Path().apply {
                                                                moveTo(tapX, tapY)
                                                                lineTo(tapX2, tapY2)
                                                            },
                                                            PathProperties(
                                                                color = hue,
                                                                strokeWidth = sliderPosition
                                                            )
                                                        )
                                                    )
                                                    // Reset tap positions for next line
                                                    tapX = 0f
                                                    tapY = 0f
                                                }

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
                        showSlider, showShapes, onToggleTriangle, onToggleSquare, onToggleCircle, onToggleLine,
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
                                valueRange = 4f..75f,

                                )
                            pencilWidth = sliderPosition
                        },
                        save = {
                            drawScope.draw(
                                density = Density(1f),
                                layoutDirection = LayoutDirection.Ltr,
                                canvas = canvas,
                                size = size,
                            ) {
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
                            }
                            val realBitmap = Bitmap.createBitmap(bitmap.width,bitmap.height,Bitmap.Config.ARGB_8888)
                            val tempCanvas = android.graphics.Canvas(realBitmap)
                            tempCanvas.drawBitmap(bitmap.asAndroidBitmap(),0f,0f,null)
                            realBitmap.saveToDisk(MainActivity.appContext)
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
                            onPencilToolClick = {isPencilToolSelected = !isPencilToolSelected},
                            onToggleShapes = onToggleShapes,
                            showShapes = showShapes,
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





private fun Int.dpToFloat(): Float {
   return (this * Resources.getSystem().displayMetrics.density)
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}