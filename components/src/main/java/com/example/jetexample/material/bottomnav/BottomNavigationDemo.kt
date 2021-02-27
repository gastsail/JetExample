package com.example.jetexample.material.bottomnav

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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

data class ListItem(val title: String, val icon: ImageVector)

private val listItems = listOf(
        ListItem("Home", Icons.Default.Home),
        ListItem("Search", Icons.Default.Search),
        ListItem("Notifications", Icons.Default.Notifications),
        ListItem("Profile", Icons.Default.Person)
)

@Composable
fun BottomNavWithLabelsDemo() {
    val selectedIndex = remember { mutableStateOf(0) }
    val context = LocalContext.current
    AlignToBottom {
        BottomNavigation(content = {
            listItems.forEachIndexed { index, item ->
                BottomNavigationItem(
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = "Icon icon")
                        },
                        label = { Text(item.title) },
                        onClick = {
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
fun BottomNavWithoutLabelsDemo() {
    val selectedIndex = remember { mutableStateOf(0) }
    val context = LocalContext.current
    AlignToBottom {
        BottomNavigation(content = {
            listItems.forEachIndexed { index, item ->
                BottomNavigationItem(
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = "Icon icon")
                        },
                        label = { Text(item.title) },
                        onClick = {
                            selectedIndex.value = index
                            showMessage(context, "${item.title} selected")
                        },
                        selected = selectedIndex.value == index,
                        alwaysShowLabel = false
                )
            }
        })
    }
}

@Composable
private fun AlignToBottom(content: @Composable () -> Unit) {
    Scaffold(topBar = {
        // [EN] If you want, you can include the toolbar we created in the other package here with Toolbar()
        // [ES] Si lo deseas, puedes incluir el toolbar que creamos en el otro paquete con Toolbar()
    },
            bottomBar = {
                content()
            },
            content = {
                // [EN] Here you can write your UI for each top destination, take in mind that you need to reac to state change from the BottomNav
                // [ES] Aquí puedes escribir la UI para cada destino, ten encuenta que deberias reaccionar a los cambios de estado del BottomNav
            })
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomNavWithoutLabels() {
    BottomNavWithoutLabelsDemo()
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomNavWithLabels() {
    BottomNavWithLabelsDemo()
}