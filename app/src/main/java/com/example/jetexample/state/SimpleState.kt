package com.example.jetexample.state

import androidx.compose.foundation.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.ui.tooling.preview.Preview


/**
 * Simple state describes how to recompose a text based on a button
 * that updates its content when clicked
 */

// Here, Counter() will recompose itself each time the value of count is changed
@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
    Button(onClick = { count.value++ }) {
        Text("I've been clicked ${count.value} times")
    }
}

@Preview
@Composable
fun PreviewCounter(){
    Counter()
}



