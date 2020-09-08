package com.example.jetexample.toolbar

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import com.example.jetexample.R

/**
 * This is an easy way to create a Toolbar, the recommended way to create
 * a toolbar is to use [IconButton] as a clickable menu item.
 * Here navigationIcon defines the left icon from the title and actions define
 * the icons at the right of the title, since its managed inside a RowScope
 * we can create a list of actions that will be arranged horizontally
 */

@Composable
fun Toolbar() {
    val context = ContextAmbient.current
    TopAppBar(title = { Text(text = "JetExample") }, navigationIcon = {
        IconButton(onClick = {
            showMessage(context,"Clicked drawer icon")
        }) {
            Icon(Icons.Filled.Menu)
        }
    }, actions = {
        IconButton(onClick = {
            showMessage(context,"Clicked save icon")
        }) {
            Icon(vectorResource(id = R.drawable.ic_baseline_save_24))
        }
    })
}

@Preview
@Composable
fun ToolbarPreview(){
    Toolbar()
}

fun showMessage(context: Context,message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}