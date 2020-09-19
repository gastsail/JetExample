package com.example.jetpoll

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.Observer
import com.example.jetpoll.data.DataSource
import com.example.jetpoll.domain.RepoImpl
import com.example.jetpoll.poll.PollScreen
import com.example.jetpoll.presentation.PollViewModel
import com.example.jetpoll.presentation.PollViewModelFactory
import com.example.jetpoll.vo.Result

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
            PollScreen(viewModel = viewModel)
        }
    }
}