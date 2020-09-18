package com.example.jetexample.state.livedata.domain

import com.example.jetexample.state.livedata.data.model.User
import com.example.jetexample.utils.Result

interface Repo {
    fun getUserList(): Result<List<User>>
}