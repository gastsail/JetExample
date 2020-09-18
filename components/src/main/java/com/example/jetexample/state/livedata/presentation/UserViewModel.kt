package com.example.jetexample.state.livedata.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.jetexample.state.livedata.domain.Repo
import com.example.jetexample.utils.Result
import kotlinx.coroutines.delay

class UserViewModel(private val repo:Repo): ViewModel() {

    /**
     * [EN]
     * We run on the default dispatcher since this is a synchronous call,
     * but remember to add Dispatchers.IO for any async work
     */

    /**
     * [ES]
     * Manejamos el dispatcher por default en livedata ya que esta es una operacion syncrona,
     * pero recordá utilizar el Dispatchers.IO para operaciones asyncronas
     */
    val fetchUserList = liveData {
        emit(Result.Loading())
        delay(2000)
        emit(repo.getUserList())
    }
}


class UserViewModelFactory(private val repo:Repo):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}