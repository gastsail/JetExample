package com.example.jetexample.material.snackbar

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * Snackbars provide brief messages about app processes at the bottom of the screen.
 */

/**
 * [ES]
 * Snackbars proveen una breve explicacion sobre algun proceso en nuestra app al fondo de la pantalla.
 */

@Composable
fun SnackbarDemo() {
    val context = ContextAmbient.current
    Column {
        val snackbarVisibleState = remember { mutableStateOf(false) }

        Button(onClick = { snackbarVisibleState.value = !snackbarVisibleState.value }) {
            if (snackbarVisibleState.value) {
                Text("Hide Snackbar")
            } else {
                Text("Show Snackbar")
            }
        }
        if (snackbarVisibleState.value) {
            Snackbar(
                    text = { Text(text = "This is a snackbar!") },
                    action = {
                        Button(onClick = {
                            showMessage(context,"Action click")
                        }) {
                            Text("MyAction")
                        }
                    },
                    modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun SnackBarPreview(){
    SnackbarDemo()
}