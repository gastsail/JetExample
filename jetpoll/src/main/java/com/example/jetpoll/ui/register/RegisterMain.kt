package com.example.jetpoll.ui.register

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpoll.MainActivity
import com.example.jetpoll.data.model.AuthCredentials
import com.example.jetpoll.presentation.AuthViewModel
import com.example.jetpoll.ui.typography
import com.example.jetpoll.utils.ShowProgress
import com.example.jetpoll.utils.showMessage
import com.example.jetpoll.vo.Result

@Composable
fun RegisterMain(viewModel:AuthViewModel){
    val context = LocalContext.current
    val registerResult: Result<Boolean> by viewModel.getRegisterResult.observeAsState(Result.Success(false))
    when(registerResult){
        is Result.Loading -> ShowProgress()
        is Result.Success -> {
            if ((registerResult as Result.Success<Boolean>).data) {
                val intent = Intent(context, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            } else {
                RegisterScreen(viewModel)
            }
        }
        is Result.Failure -> {
            RegisterScreen(viewModel)
            showMessage(context, (registerResult as Result.Failure<Boolean>).exception.message!!)
        }
    }
}

@Composable
private fun RegisterScreen(viewModel: AuthViewModel){
    val context = LocalContext.current
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    val verifpassword = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)){
        Text(
                "Register",
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
                    TextField(leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Person icon") },
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
                            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock icon") },
                            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                            value = password.value,
                            onValueChange = { password.value = it },
                            label = {
                                Text(
                                        "Password"
                                )
                            })

                    TextField(
                            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock icon") },
                            modifier = Modifier.fillMaxWidth(),
                            value = verifpassword.value,
                            onValueChange = { verifpassword.value = it },
                            label = {
                                Text(
                                        "Confirm password"
                                )
                            })
                    Button(modifier = Modifier.padding(bottom = 8.dp, top = 8.dp), onClick = {
                        if(password.value.text == verifpassword.value.text){
                            if(username.value.text.isNotEmpty()){
                               viewModel.setRegisterCredentials(AuthCredentials(username.value.text,password.value.text))
                            }else{
                                showMessage(context,"Username should not be empty")
                            }
                        }else{
                            showMessage(context,"Passwords do not match")
                        }
                    }) {
                        Text("Register")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewRegisterScreen(){
    //RegisterScreen()
}