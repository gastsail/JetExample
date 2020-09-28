package com.example.jetpoll.domain

import com.example.jetpoll.data.LoginDataSource
import com.example.jetpoll.data.model.LoginCredentials
import com.example.jetpoll.vo.Result

class LoginRepoImpl(val dataSource: LoginDataSource):LoginRepo {
    override suspend fun login(credentials:LoginCredentials): Result<Boolean> = dataSource.login(credentials)
}