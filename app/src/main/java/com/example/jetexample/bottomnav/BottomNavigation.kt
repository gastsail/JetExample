package com.example.jetexample.bottomnav

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import com.example.jetexample.R
import com.example.jetexample.utils.showMessage

/**
 * This BottomNavigation should contain different [BottomNavigationItem]s
 * which will define top level destinations in our app
 * We use a mutableStateOf to keep track of the selected tabs state while tapping
 */

val listItems = listOf("Home", "Search", "Notifications", "Profile")

@Composable
fun BottomNavWithLabels(){
    val selectedIndex = remember { mutableStateOf(0) }
    val context = ContextAmbient.current
    BottomNavigation(content = {
        listItems.forEachIndexed { index, label ->
            BottomNavigationItem(
                    icon = {
                        when (index) {
                            0 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_home_24))
                            }
                            1 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_search_24))
                            }
                            2 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_notifications_24))
                            }
                            3 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_person_24))
                            }
                        }
                    },
                    label = { Text(label) },
                    onSelect = {
                        selectedIndex.value = index
                        showMessage(context,"$label selected")
                    },
                    selected = selectedIndex.value == index
            )
        }
    })
}

@Composable
fun BottomNavWithoutLabels(){
    val selectedIndex = remember { mutableStateOf(0) }
    val context = ContextAmbient.current
    BottomNavigation(content = {
        listItems.forEachIndexed { index, label ->
            BottomNavigationItem(
                    icon = {
                        when (index) {
                            0 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_home_24))
                            }
                            1 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_search_24))
                            }
                            2 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_notifications_24))
                            }
                            3 -> {
                                Icon(vectorResource(id = R.drawable.ic_baseline_person_24))
                            }
                        }
                    },
                    label = { Text(label) },
                    onSelect = {
                        selectedIndex.value = index
                        showMessage(context,"$label selected")
                    },
                    selected = selectedIndex.value == index,
                    alwaysShowLabels = false
            )
        }
    })
}

@Preview
@Composable
fun PreviewBottomNavWithoutLabels(){
    BottomNavWithoutLabels()
}

@Preview
@Composable
fun PreviewBottomNavWithLabels(){
    BottomNavWithLabels()
}