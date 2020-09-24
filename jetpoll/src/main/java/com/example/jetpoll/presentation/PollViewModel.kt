package com.example.jetpoll.presentation

import androidx.lifecycle.*
import com.example.jetpoll.data.model.Poll
import com.example.jetpoll.domain.Repo
import com.example.jetpoll.vo.Result
import kotlinx.coroutines.Dispatchers

class PollViewModel(private val repo: Repo) : ViewModel() {

    private val createPollMutable = MutableLiveData<Poll>()

    val fetchAllPolls = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getAllPolls())
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    fun setPoll(poll: Poll){
        createPollMutable.value = poll
    }
    val createPoll = createPollMutable.switchMap {
        liveData(Dispatchers.IO) {
            emit(Result.Loading())
            try {
                emit(repo.createPoll(it))
            } catch (e: Exception) {
                emit(Result.Failure(e))
            }
        }
    }


}

class PollViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}