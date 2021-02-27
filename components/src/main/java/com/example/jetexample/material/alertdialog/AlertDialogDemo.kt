package com.example.jetexample.material.alertdialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * Alert dialog is a [Dialog] which interrupts the user with urgent information, details or actions.
 */

/**
 * [ES]
 * Un Alert Dialog es un [Dialog] el cual interrumple al usuario con información urgente, detalles o acciones.
 */

@Composable
fun AlertDialogDemo() {
    val alertState = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Button(onClick = {
        alertState.value = true
    }) {
        Text(text = "Open Dialog")
    }

    if (alertState.value) {
        AlertDialog(
                onDismissRequest = { alertState.value = false },
                title = { Text(text = "This is a title") },
                text = { Text(text = "This is a description") },
                confirmButton = {
                    Button(onClick = {
                        showMessage(context,"Confirm clicked")
                        alertState.value = false
                    }) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    Button(onClick = {
                        showMessage(context,"Dismiss clicked")
                        alertState.value = false
                    }) {
                        Text(text = "Dismiss")
                    }
                })
    }
}

@Preview(showBackground = true)
@Composable
private fun AlertDialogPreview(){
    AlertDialogDemo()
}