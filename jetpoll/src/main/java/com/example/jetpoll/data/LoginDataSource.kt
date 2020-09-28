package com.example.jetpoll.data

import com.example.jetpoll.data.model.LoginCredentials
import com.example.jetpoll.vo.Result
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class LoginDataSource {

    suspend fun login(credentials:LoginCredentials):Result<Boolean>{
        FirebaseAuth.getInstance().signInWithEmailAndPassword(credentials.username+"@jetpoll.com",credentials.password).await()
        return Result.Success(true)
    }
}