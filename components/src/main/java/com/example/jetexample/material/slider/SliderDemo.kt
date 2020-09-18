package com.example.jetexample.material.slider

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

/**
 * [EN]
 * Sliders allow users to make selections from a range of values.
 */

/**
 * [ES]
 * Los sliders le permiten al usuario hacer selecciones de un rango de valores.
 */

@Composable
fun SliderDemo() {
    val sliderPosition = remember { mutableStateOf(0f) }
    Column(modifier = Modifier.padding(24.dp)) {
        Text(text = sliderPosition.value.toString(),style = TextStyle(fontSize = 24.sp))
        Slider(value = sliderPosition.value, onValueChange = { sliderPosition.value = it })
    }
}


@Preview(showBackground = true)
@Composable
private fun SliderDemoPreview(){
    SliderDemo()
}