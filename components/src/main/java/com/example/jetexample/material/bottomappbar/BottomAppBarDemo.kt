package com.example.jetexample.material.bottomappbar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * A BottomAppBar displays actions relating to the current screen and is placed at the bottom of
 * the screen. It can also optionally display a [FloatingActionButton], which is either overlaid
 * on top of the BottomAppBar, or inset, carving a cutout in the BottomAppBar.
*/

/**
 * [ES]
 * Un BottomAppBar muestra acciones relacionadas con la pantalla que se muestra y se ubica al final de esta.
 * Puede opcionalmente mostrar un [FloatingActionButton], el cual se le puede agregar como un overlay arriba
 * del BottomAppBar, dentro de el, cortando una sección del BottomAppBar
 */

@Composable
fun BottomBarNoFabDemo(){
    val context = LocalContext.current

    Scaffold(bottomBar = {
        BottomAppBar {
            IconButton(onClick = {
                showMessage(context, "Drawer action click")
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu icon")
            }
            // [EN] The actions should be at the end of the BottomAppBar
            // [ES] Alineamos las acciones al final del bottom bar
            Spacer(Modifier.weight(1f, true))
            IconButton(onClick = {
                showMessage(context, "Favorite action clicked")
            }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite icon")
            }
            IconButton(onClick = {
                showMessage(context, "Call action clicked")
            }) {
                Icon(imageVector = Icons.Filled.Call, contentDescription = "Call icon")
            }
        }
    }) {
        // [EN] Body content goes here
        // [ES] El contenido viene aqui
    }
}

@Composable
fun BottomBarWithFabDemo(){
    val context = LocalContext.current

    Scaffold(topBar = { },
            bottomBar = {
                BottomAppBar(cutoutShape = CircleShape) {
                    IconButton(onClick = {
                        showMessage(context,"Drawer item clicked")
                    }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu icon")
                    }
                    Spacer(Modifier.weight(1f, true))
                    IconButton(onClick = {
                        showMessage(context,"Favorite action clicked")
                    }) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite icon")
                    }
                    IconButton(onClick = {
                        showMessage(context,"Call action clicked")
                    }) {
                        Icon(imageVector = Icons.Filled.Call, contentDescription = "Call icon")
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
            floatingActionButton = {
                FloatingActionButton(
                        shape = CircleShape,
                        onClick = {
                            showMessage(context,"Fab clicked")
                        }
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add icon")
                }
            }){
        // [EN] Body content goes here
        // [ES] El contenido viene aqui
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomBarNoFabPreview(){
    BottomBarNoFabDemo()
}

@Preview(showBackground = true)
@Composable
private fun BottomBarWithFabPreview(){
    BottomBarWithFabDemo()
}