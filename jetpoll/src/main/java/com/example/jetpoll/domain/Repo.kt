package com.example.jetpoll.domain

import com.example.jetpoll.data.model.Poll
import com.example.jetpoll.vo.Result

interface Repo {
    suspend fun getAllPolls(): Result<List<Poll>>
}