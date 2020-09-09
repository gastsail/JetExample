package com.example.jetexample.bottomnav

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.platform.ContextAmbient
import androidx.ui.tooling.preview.Preview
import com.example.jetexample.toolbar.Toolbar
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * This BottomNavigation should contain different [BottomNavigationItem]s
 * which will define top level destinations in our app
 * We use a mutableStateOf to keep track of the selected tabs state while tapping
 */

/**
 * [ES]
 * Este BottomNavigation deberia contener diferentes [BottomNavigationItem]s
 * los cuales definen las navegaciones principales en nuestra app
 * Usamos mutableStateOf para mantener un registro de las tabs seleccionadas cuando presionamos
 * alguna de ellas
 */

data class ListItem(val title: String, val icon: VectorAsset)

val listItems = listOf(
        ListItem("Home", Icons.Default.Home),
        ListItem("Search", Icons.Default.Search),
        ListItem("Notifications", Icons.Default.Notifications),
        ListItem("Profile", Icons.Default.Person)
)

@Composable
fun BottomNavWithLabels() {
    val selectedIndex = remember { mutableStateOf(0) }
    val context = ContextAmbient.current
    AlignToBottom {
        BottomNavigation(content = {
            listItems.forEachIndexed { index, item ->
                BottomNavigationItem(
                        icon = {
                            Icon(asset = item.icon)
                        },
                        label = { Text(item.title) },
                        onSelect = {
                            selectedIndex.value = index
                            showMessage(context, "${item.title} selected")
                        },
                        selected = selectedIndex.value == index
                )
            }
        })
    }
}

@Composable
fun BottomNavWithoutLabels() {
    val selectedIndex = remember { mutableStateOf(0) }
    val context = ContextAmbient.current
    AlignToBottom {
        BottomNavigation(content = {
            listItems.forEachIndexed { index, item ->
                BottomNavigationItem(
                        icon = {
                            Icon(asset = item.icon)
                        },
                        label = { Text(item.title) },
                        onSelect = {
                            selectedIndex.value = index
                            showMessage(context, "${item.title} selected")
                        },
                        selected = selectedIndex.value == index,
                        alwaysShowLabels = false
                )
            }
        })
    }
}

@Composable
fun AlignToBottom(content: @Composable () -> Unit) {
    Scaffold(topBar = {
        // [EN] If you want, you can include the toolbar we created in the other package here with Toolbar()
        // [ES] Si lo deseas, puedes incluir el toolbar que creamos en el otro paquete con Toolbar()
    },
            bottomBar = {
                content()
            },
            bodyContent = {
                // [EN] Here you can write your UI for each top destination, take in mind that you need to reac to state change from the BottomNav
                // [ES] Aquí puedes escribir la UI para cada destino, ten encuenta que deberias reaccionar a los cambios de estado del BottomNav
            })
}

@Preview
@Composable
fun PreviewBottomNavWithoutLabels() {
    BottomNavWithoutLabels()
}

@Preview
@Composable
fun PreviewBottomNavWithLabels() {
    BottomNavWithLabels()
}