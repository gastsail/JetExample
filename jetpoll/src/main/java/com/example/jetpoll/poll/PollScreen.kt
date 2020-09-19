package com.example.jetpoll.poll

import android.util.Log
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.jetpoll.data.model.Option
import com.example.jetpoll.ui.typography
import com.example.jetpoll.utils.showMessage
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
private fun PollComponent(
        modifier: Modifier = Modifier,
        poll: Poll,
        onOptionClick: (Option) -> Unit,
        onViewPollClick: (Poll) -> Unit) {

    Card(modifier = modifier, elevation = 8.dp, shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.height(140.dp)) {
                ProfileComponent(poll.username,poll.userphoto)
                Text(text = poll.question, modifier = Modifier.fillMaxWidth(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            for (option in poll.options) {
                OutlinedButton(modifier = Modifier.fillMaxWidth().padding(top = 4.dp, end = 8.dp, start = 8.dp), onClick = { onOptionClick(option) }) {
                    Text(text = option.name, maxLines = 1)
                }
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            Button(onClick = {
                onViewPollClick(poll)
            }, modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally).clip(CircleShape)) {
                Text(text = "View poll")
            }
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}

@Composable
private fun ProfileComponent(username:String,userphoto:String){
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        val imageModifier = Modifier.preferredSize(35.dp).drawShadow(elevation = 4.dp, shape = CircleShape).background(color = Color.White, shape = CircleShape)
        CoilImage(data = userphoto,modifier = imageModifier,contentScale = ContentScale.Crop)
        Column(modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)){
            Text(text = username, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
private fun CreatePollComponent(username:String,onCreatePollClick: () -> Unit,userphoto:String) {
    Column(modifier = Modifier.padding(16.dp)){
        Row {
            Text(text = "Bienvenido $username",modifier = Modifier.weight(1f),style = typography.h5)
            val imageModifier = Modifier.preferredSize(35.dp).drawShadow(elevation = 4.dp, shape = CircleShape).background(color = Color.White, shape = CircleShape)
            CoilImage(data = userphoto,modifier = imageModifier,contentScale = ContentScale.Crop)
        }
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(text = "Create poll and ask your friends about their opinions.",textAlign = TextAlign.Center,style = typography.body2)
        Spacer(modifier = Modifier.padding(16.dp))
        Button(shape = CircleShape,onClick = { onCreatePollClick() }){
            Text("Create")
        }
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
private fun PollList(pollList: List<Poll>) {
    val context = ContextAmbient.current
    Column {
        Text(modifier = Modifier.padding(start = 16.dp,top = 8.dp),text = "All Polls",fontSize = 20.sp,fontWeight = FontWeight.Bold,style = TextStyle(color = Color.Gray ))
        LazyRowFor(items = pollList) { poll ->
            PollComponent(modifier = Modifier.width(300.dp).padding(16.dp) ,poll = poll,
                    onOptionClick = { option ->
                        showMessage(context, "Voted for $option")
                    }, onViewPollClick = {
                showMessage(context, "Clicked to view poll results")
            })
        }
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
private fun PreviewPollScreen() {
    PollComponent(
            poll = Poll(username = "Gastón Saillén",userphoto = "",
                    question = "How many cups of coffee you drink each day ?",
                    listOf(Option(name = "1 cups"), Option(name = "2 cups"), Option(name = "3 cups"))
            ), onViewPollClick = {}, onOptionClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewCreatePollComponent(){
    CreatePollComponent(onCreatePollClick = {},username = "Gastón Saillén")
}