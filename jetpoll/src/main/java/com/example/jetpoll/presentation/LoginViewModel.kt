package com.example.jetpoll.presentation

import androidx.lifecycle.*
import com.example.jetpoll.data.model.LoginCredentials
import com.example.jetpoll.domain.LoginRepo
import com.example.jetpoll.vo.Result
import kotlinx.coroutines.Dispatchers

class LoginViewModel(val repo: LoginRepo):ViewModel() {

    private val loginCredentialsData = MutableLiveData<LoginCredentials>()

    fun setLoginCredentials(loginCredentials: LoginCredentials){
        loginCredentialsData.value = loginCredentials
    }

    val getLoginResult = loginCredentialsData.switchMap {
        liveData(Dispatchers.IO) {
            emit(Result.Loading())
            try{
                emit(repo.login(it))
            }catch (e:Exception){
                emit(Result.Failure(e))
            }
        }
    }
}

class LoginViewModelFactory(val repo:LoginRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(LoginRepo::class.java).newInstance(repo)
    }
}