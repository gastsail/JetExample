package com.example.jetexample.state.livedata.domain

import com.example.jetexample.state.livedata.data.UserDataSource
import com.example.jetexample.state.livedata.data.model.User
import com.example.jetexample.utils.Result

class RepoImpl(private val dataSource: UserDataSource):Repo {
    override fun getUserList(): Result<List<User>> = dataSource.dummyUserList
}