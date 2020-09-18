package com.example.jetexample.foundation.scrollablerow

import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

/**
 * [EN]
 * Variation of [Row] that scrolls when content is bigger than its width.
 */

/**
 * [ES]
 * Una variacion de [Row] que se desliza cuando el contenido es mas grande que el ancho de la vista.
 */

@Composable
fun ScrollableRowDemo() {
    ScrollableRow(children = {
        Row {
            Text(text = "This is my long long long long long text that I want to scroll horizontally", style = (MaterialTheme.typography).body1,fontSize = 26.sp)
        }
    })
}

@Preview(showBackground = true)
@Composable
private fun ScrollableRowPreview(){
    ScrollableRowDemo()
}