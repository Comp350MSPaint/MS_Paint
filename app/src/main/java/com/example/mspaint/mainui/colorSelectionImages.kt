package com.example.mspaint.mainui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.mspaint.R

@Composable
fun PaletteImages (
    modifier: Modifier,
    paletteState: Int
) {
    when (paletteState) {
        0-> Image(
            painter = painterResource(R.drawable.pallet_red),
            contentDescription = "red",
            modifier = modifier
        )
        1-> Image(
            painter = painterResource(R.drawable.pallet_orange),
            contentDescription = "orange",
            modifier = modifier
        )
        2-> Image(
            painter = painterResource(R.drawable.pallet_yellow),
            contentDescription = "yellow",
            modifier = modifier
        )
        3-> Image(
            painter = painterResource(R.drawable.pallet_green),
            contentDescription = "green",
            modifier = modifier
        )
        4-> Image(
            painter = painterResource(R.drawable.pallet_cyan),
            contentDescription = "cyan",
            modifier = modifier
        )
        5-> Image(
            painter = painterResource(R.drawable.pallet_white),
            contentDescription = "white",
            modifier = modifier
        )
        6-> Image(
            painter = painterResource(R.drawable.pallet_no),
            contentDescription = "black",
            modifier = modifier
        )
        7-> Image(
            painter = painterResource(R.drawable.pallet_purple),
            contentDescription = "purple",
            modifier = modifier
        )
        8-> Image(
            painter = painterResource(R.drawable.pallet_magenta),
            contentDescription = "magenta",
            modifier = modifier
        )
        9-> Image(
            painter = painterResource(R.drawable.pallet_blue),
            contentDescription = "blue",
            modifier = modifier
        )
    }
}