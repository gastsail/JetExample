package com.example.jetexample.foundation.box

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

/**
 * [EN]
 * Box is used as a container for its childs, with this container we can define width and height
 * for our child composables and also gravity.
 * By default [Box] accept multiple childs and align them into a [ColumnScope]
 */

/**
 * [ES]
 * Box es usado como un contenedor para sus hijos, con este container podemos definir width y height
 * de sus hijos composables como así tambien tu gravity.
 * Por defecto [Box] acepta multiple hijos y los alinea con un [ColumnScope]
 */

@Composable
fun BoxDemo(){
    Box(modifier = Modifier.fillMaxSize(),gravity = Alignment.Center){
        CircularProgressIndicator()
        Text(text = "Will this ever finish ?",modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun BoxDemoPreview(){
    BoxDemo()
}


