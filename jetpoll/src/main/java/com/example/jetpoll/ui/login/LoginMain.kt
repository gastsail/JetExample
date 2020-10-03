package com.example.jetpoll.ui.login

import android.content.Intent
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jetpoll.MainActivity
import com.example.jetpoll.data.model.AuthCredentials
import com.example.jetpoll.navigation.Actions
import com.example.jetpoll.navigation.BackDispatcherAmbient
import com.example.jetpoll.navigation.Destination
import com.example.jetpoll.navigation.Navigator
import com.example.jetpoll.presentation.AuthViewModel
import com.example.jetpoll.ui.createpoll.CreatePollMain
import com.example.jetpoll.ui.register.RegisterMain
import com.example.jetpoll.ui.typography
import com.example.jetpoll.utils.ProvideDisplayInsets
import com.example.jetpoll.utils.ShowProgress
import com.example.jetpoll.utils.showMessage
import com.example.jetpoll.vo.Result


@Composable
fun LoginMain(viewModel: AuthViewModel,backDispatcher:OnBackPressedDispatcher){
    val navigator: Navigator<Destination> = rememberSavedInstanceState(
            saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Login, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }

    Providers(BackDispatcherAmbient provides backDispatcher) {
        ProvideDisplayInsets {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    is Destination.Login -> {
                        LoginHome(viewModel = viewModel,onRegisterClick = actions.register)
                    }
                    is Destination.Register -> {
                        RegisterMain(viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@Composable
private fun LoginHome(viewModel: AuthViewModel,onRegisterClick:() -> Unit){
    val context = ContextAmbient.current
    val loginResult: Result<Boolean> by viewModel.getLoginResult.observeAsState(Result.Success(false))
    when(loginResult){
        is Result.Loading -> {
            ShowProgress()
        }
        is Result.Success -> {
            if ((loginResult as Result.Success<Boolean>).data) {
                val intent = Intent(context, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            } else {
                LoginScreen(viewModel,onRegisterClick)
            }
        }
        is Result.Failure -> {
            LoginScreen(viewModel = viewModel,onRegisterClick)
            showMessage(context, (loginResult as Result.Failure<Boolean>).exception.message!!)
        }
    }
}

@Composable
private fun LoginScreen(viewModel: AuthViewModel,onRegisterClick: () -> Unit){
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)){
        Text(
            "Login",
            style = typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                bottom = 8.dp
            )
        )
        Column{
            Card(elevation = 8.dp){
                Column(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(leadingIcon = { Icon(Icons.Filled.Person) },
                        modifier = Modifier.fillMaxWidth().padding(
                            bottom = 8.dp
                        ),
                        value = username.value,
                        onValueChange = { username.value = it },
                        label = {
                            Text(
                                "Username"
                            )
                        })
                    TextField(
                        leadingIcon = { Icon(Icons.Filled.Lock) },
                        modifier = Modifier.fillMaxWidth(),
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = {
                            Text(
                                "Password"
                            )
                        })
                    Button(modifier = Modifier.padding(bottom = 8.dp, top = 8.dp), onClick = {
                        viewModel.setLoginCredentials(
                            AuthCredentials(
                                username = username.value.text,
                                password = password.value.text
                            )
                        )
                    }) {
                        Text("Login")
                    }
                    Button(onClick = onRegisterClick) {
                        Text("Register")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLoginScreen(){
   //TODO mock viewmodel to render preview
   //LoginScreen()
}