package com.example.mspaint.canvasObjectData

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

var hue = Color.Red
var pencilWidth: Float = 2f
data class PathProperties(
    //val start: Offset,
    //val end: Offset,
    var color: Color = hue,
    var strokeWidth: Float = pencilWidth,
    var strokeCap: StrokeCap = StrokeCap.Round,
    var strokeJoin: StrokeJoin = StrokeJoin.Round
) {
    constructor(other: PathProperties) : this(
        strokeWidth = other.strokeWidth,
        color = other.color,
        strokeCap = other.strokeCap,
        strokeJoin = other.strokeJoin
    )
}
