package com.example.jetpoll.data

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
}