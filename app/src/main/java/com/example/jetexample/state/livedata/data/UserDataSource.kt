package com.example.jetexample.state.livedata.data

import com.example.jetexample.state.livedata.data.model.User
import com.example.jetexample.utils.Result

class UserDataSource {

    val emptyDummyUserList = Result.Success(listOf<User>())

    val dummyUserList = Result.Success(listOf(User("WIP_COIL","StackOverflow","Do you have any question ?"),
        User("WIP_COIL","Sociedad Androide","Android Youtube Channel"),
        User("WIP_COIL","John Doe","A name we find everywhere"),
        User("WIP_COIL","JetExample","Star the repo if it helped ;)")))
}