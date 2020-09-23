package com.example.jetpoll.ui.createpoll

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jetpoll.data.model.Option
import com.example.jetpoll.data.model.Poll
import com.example.jetpoll.presentation.PollViewModel

@Composable
fun CreatePollScreen(viewModel:PollViewModel){
    val text = remember { mutableStateOf(TextFieldValue("")) }
    val answer1 = remember { mutableStateOf(TextFieldValue("")) }
    val answer2 = remember { mutableStateOf(TextFieldValue("")) }
    val answer3 = remember { mutableStateOf(TextFieldValue("")) }

    Card(modifier = Modifier.fillMaxWidth().padding(16.dp),elevation = 8.dp){
        Column {
            TextField( modifier = Modifier.fillMaxWidth().padding(16.dp),
                value = text.value,
                onValueChange = { text.value = it },
                label = { Text("Write your question") })

            TextField( modifier = Modifier.fillMaxWidth().padding(16.dp),
                value = answer1.value,
                onValueChange = { answer1.value = it },
                label = { Text("Answer 1") })

            TextField( modifier = Modifier.fillMaxWidth().padding(16.dp),
                value = answer2.value,
                onValueChange = { answer2.value = it },
                label = { Text("Answer 2") })
            TextField( modifier = Modifier.fillMaxWidth().padding(16.dp),
                value = answer3.value,
                onValueChange = { answer3.value = it },
                label = { Text("Answer 3") })

            Button(modifier = Modifier.preferredSize(120.dp,50.dp).padding(bottom = 8.dp).align(Alignment.CenterHorizontally),
                shape = CircleShape,
                onClick = {
                    viewModel.createPoll(Poll("gastsail","",text.value.text, listOf(Option(name = answer1.value.text),Option(name = answer2.value.text),Option(name = answer3.value.text))))
                }
                ){
                Text("Create")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewCreatePollScreen(){
    //CreatePollScreen()
}
