package com.example.jetpoll.navigation

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.android.parcel.Parcelize

sealed class Destination : Parcelable {

    @Parcelize
    object Home : Destination()

    @Parcelize
    object CreatePoll : Destination()
}

class Actions(navigator: Navigator<Destination>) {

    val createPoll: () -> Unit = {
        navigator.navigate(Destination.CreatePoll)
    }

    val pressOnBack: () -> Unit = {
        navigator.back()
    }
}