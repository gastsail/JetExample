package com.example.jetexample.state

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


/**
 * [EN]
 * Simple state describes how to recompose a text based on a button
 * that updates its content when clicked
 */

/**
 * [ES]
 * Esta clase describe como hacer recomposicion de un texto basado en el click
 * de un boton, en donde modificamos el texto cuando presionamos el boton
 */

// [EN] Here, Counter() will recompose itself each time the value of count is changed
// [ES] Aquí, Counter() va a recomponerse cada vez que el valor de count cambia
@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
    Button(onClick = { count.value++ }) {
        Text("I've been clicked ${count.value} times")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCounter(){
    Counter()
}



