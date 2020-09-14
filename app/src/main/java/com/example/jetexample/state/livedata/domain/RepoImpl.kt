package com.example.jetexample.state.livedata.domain

import com.example.jetexample.state.livedata.data.UserDataSource
import com.example.jetexample.state.livedata.data.model.User

class RepoImpl(private val dataSource: UserDataSource):Repo {
    override fun getUserList(): List<User> = dataSource.dummyUserList
}