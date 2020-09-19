package com.example.jetpoll.data

import com.example.jetpoll.data.model.Option
import com.example.jetpoll.data.model.Poll
import com.example.jetpoll.vo.Result
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class DataSource {

    private val pollReference = FirebaseFirestore.getInstance().collection("polls")

    suspend fun getAllPolls(): Result<List<Poll>> {
        val pollList = mutableListOf<Poll>()
        val pollQuery = pollReference.get().await()
        for(poll in pollQuery){
            pollList.add(poll.toObject(Poll::class.java))
        }
        return Result.Success(pollList.toList())
    }

    val dummyPollList = Result.Success(listOf(Poll(userName = "Lionel Messi",
            userPhoto = "https://www.mykhel.com/thumb/250x90x250/football/players/4/19054.jpg",
            question = "How many cups of coffee you drink each day ? ☕", listOf(Option(3,"1 cups"),Option(6,"2 cups"),Option(1,"3 cups"))
    ),Poll(userName = "Gastón Saillén",
            userPhoto = "https://avatars2.githubusercontent.com/u/24615408?s=460&u=8a985792aa795ada276b4d567baba1c732ab02fb&v=4",
            question = "Do you like dogs ? ", listOf(Option(3,"Yes :D"),Option(6,"Maybe :/"),Option(1,"No >:("))
    )))
}