package com.example.jetpoll.ui.home

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jetpoll.data.model.Option
import com.example.jetpoll.data.model.Poll
import com.example.jetpoll.ui.typography
import com.example.jetpoll.utils.showMessage
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PollComponent(
        poll: Poll,
        onOptionClick: (Option) -> Unit,
        onVotePollClick: (Poll) -> Unit) {

    val voteState = remember { mutableStateOf(false)}

    Card(modifier = Modifier.width(300.dp).padding(16.dp), elevation = 8.dp, shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Column(modifier = Modifier.height(140.dp)) {
                ProfileComponent(poll.userName,poll.userPhoto)
                Text(text = poll.question, modifier = Modifier.fillMaxWidth(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            for (option in poll.options) {
                OutlinedButton(modifier = Modifier.fillMaxWidth().padding(top = 4.dp, end = 8.dp, start = 8.dp), onClick = {
                    voteState.value = true
                    onOptionClick(option)
                }) {
                    Text(text = option.name, maxLines = 1)
                }
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            if(voteState.value){
                Button(onClick = {
                    onVotePollClick(poll)
                }, modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally).clip(
                        CircleShape
                )) {
                    Text(text = "Vote")
                }
            }

            Spacer(modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}

@Composable
fun ProfileComponent(username:String,userphoto:String){
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        val imageModifier = Modifier.preferredSize(35.dp).drawShadow(elevation = 4.dp, shape = CircleShape).background(color = Color.White, shape = CircleShape)
        CoilImage(data = userphoto,modifier = imageModifier,contentScale = ContentScale.Crop)
        Column(modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)){
            Text(text = username, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun CreatePollComponent(modifier: Modifier = Modifier, username:String, onCreatePollClick: () -> Unit, userphoto:String) {
    Column(modifier = modifier){
        Row {
            Text(text = "Welcome $username",modifier = Modifier.weight(1f),style = typography.h5,fontWeight = FontWeight.Bold)
            val imageModifier = Modifier.preferredSize(45.dp).drawShadow(elevation = 4.dp, shape = CircleShape).background(color = Color.White, shape = CircleShape)
            CoilImage(data = userphoto,modifier = imageModifier,contentScale = ContentScale.Crop)
        }
        Spacer(modifier = Modifier.padding(top = 4.dp))
        Text(modifier = Modifier.width(240.dp).wrapContentHeight(),text = "Create poll and ask your friends about their opinions.",textAlign = TextAlign.Start,style = typography.body1)
        Spacer(modifier = Modifier.padding(16.dp))
        Button(modifier = Modifier.preferredSize(120.dp,50.dp),shape = CircleShape,onClick = onCreatePollClick ){
            Text("Create")
        }
    }
}

@Composable
fun PollListComponent(modifier: Modifier = Modifier, pollList: List<Poll>) {
    val context = ContextAmbient.current
    Column(modifier = modifier) {
        Text(modifier = Modifier.padding(start = 16.dp,top = 8.dp),text = "All Polls",fontSize = 20.sp,fontWeight = FontWeight.Bold,style = TextStyle(color = Color.Gray ))
        LazyRowFor(items = pollList) { poll ->
            PollComponent(poll = poll,
                onOptionClick = { option ->
                    showMessage(context, "Voted for $option")
                }, onVotePollClick = {
                    showMessage(context, "Clicked to view poll results")
                })
        }
    }
}


@Preview
@Composable
private fun PreviewPollScreen() {
    PollComponent(
        poll = Poll(userName = "Gastón Saillén",userPhoto = "",
            question = "How many cups of coffee you drink each day ?",
            options = listOf(Option(name = "1 cups"), Option(name = "2 cups"), Option(name = "3 cups"))
        ), onVotePollClick = {}, onOptionClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewCreatePollComponent(){
    CreatePollComponent(onCreatePollClick = {},username = "Gastón Saillén",userphoto = "")
}