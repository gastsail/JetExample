package com.example.jetpoll.domain

import com.example.jetpoll.data.model.LoginCredentials
import com.example.jetpoll.vo.Result

interface LoginRepo {
    suspend fun login(credentials:LoginCredentials):Result<Boolean>
}