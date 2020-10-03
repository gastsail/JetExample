package com.example.jetpoll.domain

import com.example.jetpoll.data.LoginDataSource
import com.example.jetpoll.data.model.AuthCredentials
import com.example.jetpoll.vo.Result

class LoginRepoImpl(private val dataSource: LoginDataSource):LoginRepo {
    override suspend fun login(credentials:AuthCredentials): Result<Boolean> = dataSource.login(credentials)
    override suspend fun register(credentials: AuthCredentials): Result<Boolean> = dataSource.register(credentials)
}