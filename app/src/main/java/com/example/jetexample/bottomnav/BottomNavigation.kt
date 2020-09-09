package com.example.jetexample.bottomnav

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
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
import com.example.jetexample.utils.showMessage

/**
 * This BottomNavigation should contain different [BottomNavigationItem]s
 * which will define top level destinations in our app
 * We use a mutableStateOf to keep track of the selected tabs state while tapping
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

@Composable
fun BottomNavWithoutLabels() {
    val selectedIndex = remember { mutableStateOf(0) }
    val context = ContextAmbient.current
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