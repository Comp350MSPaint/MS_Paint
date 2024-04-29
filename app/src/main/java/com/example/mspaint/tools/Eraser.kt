package com.example.mspaint.tools

import com.example.mspaint.canvasObjectData.hue
var restoreToHue = hue  //This var is used to "save" the color of pen/line
fun eraser () {
    // TODO: change the hue to the color of the canvas which isn't white...Maybe we could just leave it
    restoreToHue = hue  //Each time we click eraser, the color will be saved.
    hue = androidx.compose.ui.graphics.Color.White
}