package com.example.jetexample.state.livedata.domain

import com.example.jetexample.state.livedata.data.UserDataSource
import com.example.jetexample.state.livedata.data.model.User
import com.example.jetexample.utils.Result

/**
 * [EN]
 * You can call dataSource.emptyDummyUserList to test the empty Composable on the UserListScreen
 */

/**
 * [ES]
 * Puedes llamar a dataSource.emptyDummyUserList para testear el Composable vacio de UserListScreen
 */

class RepoImpl(private val dataSource: UserDataSource):Repo {
    override fun getUserList(): Result<List<User>> = dataSource.dummyUserList
}