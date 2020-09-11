package com.example.jetexample.foundation.scrollablecolumn

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

/**
 * [EN]
 * Variation of [Column] that scrolls when content is bigger than its height.
 */

/**
 * [ES]
 * Variacion de [Column] el cual hace scroll cuando el contenido es mas grande que el alto de la pantalla.
 */

@Composable
fun ScrollableColumnDemo() {
    ScrollableColumn(modifier = Modifier.fillMaxWidth().padding(16.dp),children = {
        Column {
            for(x in 1..50){
                Text("$x",fontSize = 26.sp)
            }
        }
    })
}

@Preview
@Composable
private fun ScrollableColumnPreview(){
    ScrollableColumnDemo()
}