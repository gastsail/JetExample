package com.example.jetexample.material.drawerlayout

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawerLayout
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview

/**
 * [EN]
 * Navigation drawers provide access to destinations in your app.
 *
 * Modal navigation drawers block interaction with the rest of an app’s content with a scrim.
 * They are elevated above most of the app’s UI and don’t affect the screen’s layout grid.
 *
 */

/**
 * [ES]
 * Navigation drawers proveen acceso a distintos destinos en tu app.
 *
 * Un modal navigation drawer bloquea la interaccion con el resto del contenido de la app con un scrim.
 * Son elevados arriba de la UI principal y no afecta a la layout en pantalla
 */

@Composable
fun ModalDrawerDemo() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalDrawerLayout(
            drawerState = drawerState,
            drawerContent = {
                Column {
                    Button(onClick = { drawerState.close() }) {
                        Text("Close drawer")
                    }
                }
            },
            bodyContent = {
                Column {
                    Button(onClick = { drawerState.open() }) {
                        Text("Open drawer")
                    }
                }
            }
    )
}

@Preview
@Composable
private fun ModalDrawerDemoPreview(){
    ModalDrawerDemo()
}