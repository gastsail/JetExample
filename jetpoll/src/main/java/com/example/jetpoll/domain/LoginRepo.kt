package com.example.jetpoll.domain

import com.example.jetpoll.data.model.AuthCredentials
import com.example.jetpoll.vo.Result

interface LoginRepo {
    suspend fun login(credentials:AuthCredentials):Result<Boolean>
    suspend fun register(credentials:AuthCredentials):Result<Boolean>
}