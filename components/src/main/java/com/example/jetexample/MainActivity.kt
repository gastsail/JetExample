package com.example.jetexample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jetexample.foundation.box.BoxDemo
import com.example.jetexample.material.cardview.CardViewDemo
import com.example.jetexample.material.checkbox.CheckBoxDemo
import com.example.jetexample.material.divider.DividerDemo
import com.example.jetexample.material.drawerlayout.ModalDrawerDemo
import com.example.jetexample.material.modalbottomsheet.ModalBottomSheetLayoutDemo
import com.example.jetexample.material.slider.SliderDemo
import com.example.jetexample.material.snackbar.SnackbarDemo
import com.example.jetexample.material.switch.SwitchDemo
import com.example.jetexample.material.toolbar.ToolbarDemo
import com.example.jetexample.state.livedata.data.MainDataSource
import com.example.jetexample.state.livedata.domain.RepoImpl
import com.example.jetexample.state.livedata.presentation.MainViewModel
import com.example.jetexample.state.livedata.presentation.UserViewModelFactory


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

    // [EN] Viewmodel to provide to Data for UserScreen, RecipeRow, RecipeColumn and others
    // [ES] Viewmodel para proveer datos a UserScreen, RecipeRow, RecipeColumn y otros
    private val viewModel by viewModels<MainViewModel> {
        UserViewModelFactory(
            RepoImpl(
                MainDataSource()
            )
        )
    }

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // [EN] Call inside Column what you want to try out
            // [ES] Llama dentro de Column lo que quieres probar
            // Example call: Toolbar(), RecipeColumnDemo(viewModel.getRecipeList)
            Column {
                //TODO CALL HERE COMPOSABLE DEMOS , Example: BoxDemo()
                BoxDemo()
            }
        }
    }
}














