package com.example.jetpoll

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.jetpoll.data.LoginDataSource
import com.example.jetpoll.domain.LoginRepoImpl
import com.example.jetpoll.presentation.AuthViewModel
import com.example.jetpoll.presentation.LoginViewModelFactory
import com.example.jetpoll.ui.login.LoginMain

class LoginActivity: AppCompatActivity() {

    private val viewModel by viewModels<AuthViewModel> { LoginViewModelFactory(LoginRepoImpl(
        LoginDataSource()
    )) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginMain(viewModel = viewModel,backDispatcher = onBackPressedDispatcher)
        }
    }
}