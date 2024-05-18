package com.example.mspaint.mainui

import androidx.compose.foundation.Image
// import androidx.compose.foundation.layout.BoxScopeInstance.align

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.mspaint.R


@Composable
fun ToolbarUI (
    modifier: Modifier,
    toolbarState: Int
) {
    when (toolbarState) {
        0-> Image(
            painter = painterResource(R.drawable.toolbarn_palette),
            contentDescription = "shape",
            modifier = modifier
        )
        1-> Image(
            painter = painterResource(R.drawable.toolbarn_options),
            contentDescription = "shape",
            modifier = modifier
        )
        2-> Image(
            painter = painterResource(R.drawable.toolbarn),
            contentDescription = "shape",
            modifier = modifier
        )
        3-> Image(
            painter = painterResource(R.drawable.toolbarn_eraser),
            contentDescription = "shape",
            modifier = modifier
        )
        4-> Image(
            painter = painterResource(R.drawable.toolbarn_shapes),
            contentDescription = "shape",
            modifier = modifier
        )
        5-> Image(
            painter = painterResource(R.drawable.toolbarn_pencil),
            contentDescription = "shape",
            modifier = modifier
        )
    }
}
