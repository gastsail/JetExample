package com.example.jetexample.state.livedata.domain

import com.example.jetexample.state.livedata.data.model.User

interface Repo {
    fun getUserList(): List<User>
}