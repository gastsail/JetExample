package com.example.jetpoll.ui.home

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import com.example.jetpoll.navigation.Actions
import com.example.jetpoll.navigation.BackDispatcherAmbient
import com.example.jetpoll.navigation.Destination
import com.example.jetpoll.navigation.Navigator
import com.example.jetpoll.presentation.PollViewModel
import com.example.jetpoll.ui.createpoll.CreatePollMain
import com.example.jetpoll.utils.ProvideDisplayInsets

@Composable
fun PollMain(viewModel: PollViewModel, backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSavedInstanceState(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }

    Providers(BackDispatcherAmbient provides backDispatcher) {
        ProvideDisplayInsets {
            Crossfade(navigator.current) { destination ->
                when (destination) {
                    is Destination.Home -> {
                        PollHome(viewModel = viewModel,onCreatePollClick = actions.createPoll)
                    }
                    is Destination.CreatePoll -> {
                        CreatePollMain(viewModel)
                    }
                }
            }
        }
    }
}