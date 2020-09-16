package com.example.jetexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
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

    private val userViewModel by viewModels<UserViewModel> { UserViewModelFactory(RepoImpl(UserDataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // [EN] Call here what you want to try out
            // [ES] Llama aqui que es lo que quieres probar
            // Example: Toolbar()
            UserScreen(userViewModel = userViewModel)
        }
    }
}














