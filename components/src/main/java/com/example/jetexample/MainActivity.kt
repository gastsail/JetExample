package com.example.jetexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetexample.foundation.box.BoxDemo
import com.example.jetexample.foundation.clickabletext.ClickableTextDemo
import com.example.jetexample.foundation.lazycolumnfor.RecipeColumnListDemo
import com.example.jetexample.foundation.lazycolumnfor.recipeList
import com.example.jetexample.foundation.lazyrowfor.RecipeRowListDemo
import com.example.jetexample.foundation.textfield.TextFieldDemo
import com.example.jetexample.material.alertdialog.AlertDialogDemo
import com.example.jetexample.material.bottomappbar.BottomBarNoFabDemo
import com.example.jetexample.material.bottomappbar.BottomBarWithFabDemo
import com.example.jetexample.material.bottomnav.BottomNavWithLabelsDemo
import com.example.jetexample.material.bottomnav.BottomNavWithoutLabelsDemo
import com.example.jetexample.material.checkbox.CheckBoxDemo
import com.example.jetexample.material.divider.DividerDemo
import com.example.jetexample.material.drawerlayout.ModalDrawerDemo
import com.example.jetexample.material.modalbottomsheet.ModalBottomSheetLayoutDemo
import com.example.jetexample.material.slider.SliderDemo
import com.example.jetexample.material.snackbar.SnackbarDemo
import com.example.jetexample.material.switch.SwitchDemo
import com.example.jetexample.material.toolbar.ToolbarDemo
import com.example.jetexample.state.livedata.data.UserDataSource
import com.example.jetexample.state.livedata.domain.RepoImpl
import com.example.jetexample.state.livedata.presentation.UserViewModel
import com.example.jetexample.state.livedata.presentation.UserViewModelFactory
import com.example.jetexample.state.livedata.ui.UserScreen


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

    // [EN] Viewmodel to provide to UserScreen demo
    // [ES] Viewmodel para proveer a UserScreen demo
    private val userViewModel by viewModels<UserViewModel> { UserViewModelFactory(RepoImpl(UserDataSource())) }

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // [EN] Call here what you want to try out
            // [ES] Llama aqui que es lo que quieres probar
            // Example: Toolbar()
        }
    }
}














