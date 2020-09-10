package com.example.jetexample.bottomappbar

import androidx.compose.foundation.Icon
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
import androidx.compose.ui.platform.ContextAmbient
import androidx.ui.tooling.preview.Preview
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
fun BottomBarNoFab(){
    val context = ContextAmbient.current

    Scaffold(bottomBar = {
        BottomAppBar {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu)
            }
            // [EN] The actions should be at the end of the BottomAppBar
            // [ES] Alineamos las acciones al final del bottom bar
            Spacer(Modifier.weight(1f, true))
            IconButton(onClick = {
                showMessage(context,"Favorite action clicked")
            }) {
                Icon(Icons.Filled.Favorite)
            }
            IconButton(onClick = {
                showMessage(context,"Call action clicked")
            }) {
                Icon(Icons.Filled.Call)
            }
        }
    }) {
        // [EN] Body content goes here
        // [ES] El contenido viene aqui
    }
}

@Composable
fun BottomBarWithFab(){
    val context = ContextAmbient.current

    Scaffold(topBar = { },
            bottomBar = {
                BottomAppBar(cutoutShape = CircleShape) {
                    IconButton(onClick = {
                        showMessage(context,"Drawer item clicked")
                    }) {
                        Icon(Icons.Filled.Menu)
                    }
                    Spacer(Modifier.weight(1f, true))
                    IconButton(onClick = {
                        showMessage(context,"Favorite action clicked")
                    }) {
                        Icon(Icons.Filled.Favorite)
                    }
                    IconButton(onClick = {
                        showMessage(context,"Call action clicked")
                    }) {
                        Icon(Icons.Filled.Call)
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
                    Icon(asset = Icons.Filled.Add)
                }
            }){
        // [EN] Body content goes here
        // [ES] El contenido viene aqui
    }
}

@Preview
@Composable
fun BottomBarNoFabPreview(){
    BottomBarNoFab()
}

@Preview
@Composable
fun BottomBarWithFabPreview(){
    BottomBarWithFab()
}