package com.example.jetexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.jetexample.foundation.lazycolumnfor.RecipeColumnList
import com.example.jetexample.foundation.lazyrowfor.RecipeRowList
import com.example.jetexample.material.alertdialog.AlertDialogDemo
import com.example.jetexample.material.bottomappbar.BottomBarNoFab
import com.example.jetexample.material.bottomappbar.BottomBarWithFab
import com.example.jetexample.material.cardview.CardViewDemo
import com.example.jetexample.material.checkbox.CheckBoxDemo
import com.example.jetexample.material.drawerlayout.ModalDrawerDemo
import com.example.jetexample.material.slider.SliderDemo
import com.example.jetexample.material.toolbar.Toolbar

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







