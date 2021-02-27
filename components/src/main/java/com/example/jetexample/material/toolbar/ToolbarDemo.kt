package com.example.jetexample.material.toolbar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetexample.R
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * This is an easy way to create a Toolbar, the recommended way to create
 * a toolbar is to use [IconButton] as a clickable menu item.
 * Here navigationIcon defines the left icon from the title and actions define
 * the icons at the right of the title, since its managed inside a RowScope
 * we can create a list of actions that will be arranged horizontally
 */

/**
 * [ES]
 * Esta es una forma facil de crear un Toolbar, la forma recomendada de manejar las acciones
 * es utilizando [IconButton] como clickable para cada item de nuestro toolbar
 * Aquí, navigationIcon define el icono a la izquierda de nuestro titulo en el Toolbar y
 * las acciones (actions) definen los iconos a la derecha del titulo.
 * Ya que está contenido en un RowScope, cuando creamos una lista de actions , se van a acomodar horizontalmente
 */

@Composable
fun ToolbarDemo() {
    val context = LocalContext.current
    TopAppBar(title = { Text(text = "JetExample") }, navigationIcon = {
        IconButton(onClick = {
            showMessage(context,"Clicked drawer icon")
        }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu icon")
        }
    }, actions = {
        IconButton(onClick = {
            showMessage(context,"Clicked save icon")
        }) {
            Icon(painterResource(id = R.drawable.ic_baseline_save_24), contentDescription = "Baseline save")
        }
    })
}

@Preview(showBackground = true)
@Composable
private fun ToolbarPreview(){
    ToolbarDemo()
}