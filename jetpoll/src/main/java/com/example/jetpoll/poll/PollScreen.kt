package com.example.jetpoll.poll

import android.util.Log
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.align
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.jetpoll.data.model.Option
import com.example.jetpoll.utils.showMessage

@Composable
private fun PollComponent(poll: Poll, onOptionClick: (Option) -> Unit, onViewPollClick: (Poll) -> Unit) {
    Card(modifier = Modifier.width(300.dp).padding(16.dp),elevation = 8.dp,shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = poll.question,modifier = Modifier.fillMaxWidth(),style = TextStyle(fontSize = 24.sp),fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(top = 16.dp))
            for (option in poll.options) {
                OutlinedButton(modifier = Modifier.fillMaxWidth().padding(top = 4.dp,end = 8.dp,start = 8.dp),onClick = {onOptionClick(option)}) {
                    Text(text = option.name)
                }
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            Button(onClick = {
                onViewPollClick(poll)
            },modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally).clip(CircleShape)) {
                Text(text = "View poll")
            }
        }
    }
}

@Composable
private fun PollList(pollList: List<Poll>) {
    val context = ContextAmbient.current
        LazyRowFor(items = pollList) { poll ->
            PollComponent(poll = poll,
                    onOptionClick = { option ->
                        showMessage(context,"Voted for $option")
                    }, onViewPollClick = {
                showMessage(context,"Clicked to view poll results")
            })
        }
}


@Composable
fun PollScreen(viewModel: PollViewModel) {
    val pollResult: Result<List<Poll>> by viewModel.fetchAllPolls.observeAsState(Result.Success(emptyList()))
    when (pollResult) {
        is Result.Loading -> ShowProgress()
        is Result.Success -> PollList(pollList = (pollResult as Result.Success<List<Poll>>).data)
        is Result.Failure -> ShowError((pollResult as Result.Failure<List<Poll>>).exception)
    }
}

@Composable
private fun ShowProgress() {
    Box(modifier = Modifier.fillMaxSize(), gravity = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ShowError(exception: Exception) {
    Box(modifier = Modifier.fillMaxSize(), gravity = Alignment.Center) {
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
                    listOf(Option(name = "1 cups"), Option(name = "2 cups"), Option(name = "3 cups"))
            ),onViewPollClick = {},onOptionClick = {}
    )
}