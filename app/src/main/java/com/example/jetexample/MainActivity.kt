package com.example.jetexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.example.jetexample.foundation.clickabletext.ClickableTextDemo
import com.example.jetexample.foundation.scrollablecolumn.ScrollableColumnDemo
import com.example.jetexample.foundation.scrollablerow.ScrollableRowDemo
import com.example.jetexample.material.snackbar.SnackbarDemo
import com.example.jetexample.material.switch.SwitchDemo

/**
 * [EN]
 * How to run the samples:
 * Just call the Composable methods of the packages inside setContent
 * Example: setContent { Toolbar() } ---> this will trigger the Toolbar() composable
 * inside the toolbar package where this UI code resides
 */

/**
 * [ES]
 * Como correr ejemplos:
 * Solo llama a la funcion composable de cualquiera de los paquetes del proyecto
 * Ejemplo: setContent { Toolbar() } ---> esto va a lanzar el composable del Toolbar()
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // [EN] Call here what you want to try out
            // [ES] Llama aqui que es lo que quieres probar
            // Example: Toolbar()
        }
    }
}










