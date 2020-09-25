package com.example.jetpoll.ui.createpoll

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.jetpoll.utils.ShowError
import com.example.jetpoll.utils.ShowProgress
import com.example.jetpoll.utils.showMessage
import com.example.jetpoll.vo.Result

@Composable
fun CreatePollScreen(viewModel:PollViewModel){
    val pollResult: Result<Boolean> by viewModel.createPoll.observeAsState(Result.Success(false))
    val context = ContextAmbient.current

    when (pollResult) {
        is Result.Loading -> {
            ShowProgress()
        }
        is Result.Success -> {
            if ((pollResult as Result.Success<Boolean>).data) {
                showMessage(context, "Poll created :)")
            } else {
                CreatePollComponent(viewModel)
            }

        }
        is Result.Failure -> {
            ShowError(exception = (pollResult as Result.Failure<Boolean>).exception)
        }
    }
}

@Composable
fun CreatePollComponent(viewModel:PollViewModel){
    val context = ContextAmbient.current
    val text = remember { mutableStateOf(TextFieldValue("")) }
    val answer1 = remember { mutableStateOf(TextFieldValue("")) }
    val answer2 = remember { mutableStateOf(TextFieldValue("")) }
    val answer3 = remember { mutableStateOf(TextFieldValue("")) }

    Card(modifier = Modifier.fillMaxWidth().padding(16.dp),elevation = 8.dp){
        Column {
            TextField(modifier = Modifier.fillMaxWidth().padding(16.dp),
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

            Button(modifier = Modifier.preferredSize(120.dp, 50.dp).padding(bottom = 8.dp).align(Alignment.CenterHorizontally),
                    shape = CircleShape,
                    onClick = {
                        val question = text.value.text
                        val firstAnswer = answer1.value.text
                        val secondAnswer = answer2.value.text
                        val thirdAnswer = answer3.value.text
                        if(question.isNotEmpty() && firstAnswer.isNotEmpty() && secondAnswer.isNotEmpty() && thirdAnswer.isNotEmpty()){
                            viewModel.setPoll(Poll("gastsail", "", question, listOf(Option(name = firstAnswer), Option(name = secondAnswer), Option(name = thirdAnswer))))
                        }else{
                            showMessage(context,"Some of the fields are empty")
                        }
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
