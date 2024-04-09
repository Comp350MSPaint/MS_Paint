package com.example.mspaint.mainui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mspaint.canvasObjectData.Line
import com.example.mspaint.ui.theme.PureBlack

@Composable
fun MainScreen() {
    // list of lines
    val lines = remember {
        mutableStateListOf<Line>()
    }
    val undoneLines = remember {
        mutableStateListOf<Line>()
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier

        ) {
            //the actual canvas
            Canvas(
                // sets up the canvas
                modifier = Modifier
                    .fillMaxSize()
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
                            }
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