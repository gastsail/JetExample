package com.example.jetpoll.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.jetpoll.domain.Repo
import com.example.jetpoll.vo.Result
import kotlinx.coroutines.Dispatchers

class PollViewModel(repo: Repo): ViewModel() {

    val fetchAllPolls = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try{
            emit(repo.getAllPolls())
        }catch (e:Exception){
            emit(Result.Failure(e))
        }
    }

}

class PollViewModelFactory(private val repo:Repo):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}