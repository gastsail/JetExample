package com.example.jetpoll.poll

import android.util.Log
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jetpoll.data.model.Poll
import com.example.jetpoll.presentation.PollViewModel
import com.example.jetpoll.vo.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.example.jetpoll.data.model.Option

@Composable
private fun PollComponent(poll: Poll) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column {
            Text(text = poll.question)
            Spacer(modifier = Modifier.padding(top = 16.dp))
            for(pollObj in poll.options){
                Text(text = pollObj.name)
            }
        }
    }
}

@Composable
private fun PollList(pollList:List<Poll>){
    LazyRowFor(items = pollList) { poll ->
        PollComponent(poll = poll)
    }
}


@Composable
fun PollScreen(viewModel:PollViewModel){
    val pollResult: Result<List<Poll>> by viewModel.fetchAllPolls.observeAsState(Result.Success(emptyList()))
    when(pollResult){
        is Result.Loading -> ShowProgress()
        is Result.Success -> PollList(pollList = (pollResult as Result.Success<List<Poll>>).data)
        is Result.Failure -> ShowError((pollResult as Result.Failure<List<Poll>>).exception)
    }
}

@Composable
private fun ShowProgress(){
    Box(modifier = Modifier.fillMaxSize(),gravity = Alignment.Center){
        CircularProgressIndicator()
    }
}

@Composable
private fun ShowError(exception: Exception) {
    Box(modifier = Modifier.fillMaxSize(),gravity = Alignment.Center){
        Text(text = "An error ocurred fetching the polls.")
    }
    Log.e("PollFetchError", exception.message!!)
}

@Preview
@Composable
fun PreviewPollScreen() {
    PollComponent(
        poll = Poll(
            "How many cups of coffee you drink each day ?",
            listOf(Option(name = "1 cups"),Option(name = "2 cups"),Option(name = "3 cups"))
        )
    )
}