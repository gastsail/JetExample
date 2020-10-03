package com.example.jetpoll.data

import com.example.jetpoll.data.model.AuthCredentials
import com.example.jetpoll.vo.Result
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class LoginDataSource {

    suspend fun login(credentials:AuthCredentials):Result<Boolean>{
        FirebaseAuth.getInstance().signInWithEmailAndPassword(credentials.username+"@jetpoll.com",credentials.password).await()
        return Result.Success(true)
    }

    suspend fun register(credentials:AuthCredentials):Result<Boolean>{
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(credentials.username+"@jetpoll.com",credentials.password).await()
        return Result.Success(true)
    }
}