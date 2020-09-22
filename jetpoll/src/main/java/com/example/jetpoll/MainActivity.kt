package com.example.jetpoll

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.jetpoll.data.DataSource
import com.example.jetpoll.domain.RepoImpl
import com.example.jetpoll.ui.home.PollMain
import com.example.jetpoll.presentation.PollViewModel
import com.example.jetpoll.presentation.PollViewModelFactory

/**
 * [EN]
 * JetPoll is an app that let you create polls with options that others can select
 * Currently WIP
 */

/**
 * [ES]
 * JetPoll es una aplicación en la cual puedes crear encuestas con opciones que otros pueden responder
 * Actualmente en construccion
 */

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<PollViewModel> { PollViewModelFactory(RepoImpl(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PollMain(viewModel = viewModel,backDispatcher = onBackPressedDispatcher)
        }
    }
}