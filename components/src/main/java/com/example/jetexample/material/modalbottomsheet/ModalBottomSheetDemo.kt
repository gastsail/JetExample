package com.example.jetexample.material.modalbottomsheet

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetexample.ui.typography

@ExperimentalMaterialApi
@Composable
fun ModalBottomSheetLayoutDemo() {
    val modalState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    Button(modifier = Modifier.padding(16.dp), onClick = { modalState.show() }) {
        Text("Show Bottom Sheet")
    }

    ModalBottomSheetLayout(sheetState = modalState, sheetContent = {
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            text = "Title",
            fontWeight = FontWeight.Bold,
            style = typography.h5
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            text = "Content example right here :)",
            style = typography.body1
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp)) {
            Button(modifier = Modifier.padding(end = 8.dp), onClick = { modalState.hide() }) {
                Text("Cancel")
            }
            Button(onClick = { modalState.hide() }) {
                Text("Ok")
            }
        }
    }, sheetElevation = 8.dp) {}
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
private fun ModalBottomSheetLayoutPreview() {
    ModalBottomSheetLayoutDemo()
}