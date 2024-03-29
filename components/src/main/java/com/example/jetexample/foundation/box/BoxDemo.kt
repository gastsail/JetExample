package com.example.jetexample.foundation.box


import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * [EN]
 * Box is used as a container for its childs, with this container we can define width and height
 * for our child composables and also gravity.
 * [Box] accept multiple childs and we can align them into a [ColumnScope] or [RowScope]
 */

/**
 * [ES]
 * Box es usado como un contenedor para sus hijos, con este container podemos definir width y height
 * de sus hijos composables como así tambien tu gravity.
 * [Box] acepta multiple hijos y los podemos alinear con un [ColumnScope] o [RowScope]
 */

@Composable
fun BoxDemo(){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Text(text = "Will this ever finish ?", modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxDemoPreview(){
    BoxDemo()
}


