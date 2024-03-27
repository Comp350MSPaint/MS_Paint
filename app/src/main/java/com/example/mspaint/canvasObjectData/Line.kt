package com.example.mspaint.canvasObjectData

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

var hue = Color.Red
var pencilWidth: Float = 2f
data class Line(
    val start: Offset,
    val end: Offset,
    val color: Color = hue,
    var strokeWidth: Dp = pencilWidth.dp
)
