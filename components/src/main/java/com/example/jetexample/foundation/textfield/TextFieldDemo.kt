package com.example.jetexample.foundation.textfield

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

/**
 * [EN]
 * Material Design implementation of a
 * [Filled TextField](https://material.io/components/text-fields/#filled-text-field)
 *
 * If you are looking for an outlined version, see [OutlinedTextField].
 */

/**
 * [ES]
 * Implementacion de Material Design ver
 * [Filled TextField](https://material.io/components/text-fields/#filled-text-field)
 *
 * Si estas buscando por una version delineada (con bordes), usa [OutlinedTextField].
 */

@Composable
fun TextFieldDemo(){
    val text = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text("This is a label") })
}


@Preview(showBackground = true)
@Composable
private fun TextFieldPreview(){
    TextFieldDemo()
}