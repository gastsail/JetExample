package com.example.jetexample.state.livedata.data

import com.example.jetexample.state.livedata.data.model.User
import com.example.jetexample.utils.Result

class UserDataSource {

    val emptyDummyUserList = Result.Success(listOf<User>())

    val dummyUserList = Result.Success(listOf(User("https://televistar.com/media/u_media/stack.png","StackOverflow","Do you have any question ?"),
        User("https://yt3.ggpht.com/a/AATXAJxeN7R91gPRARx610jOGrUC0Q_0n3BxOV7aTHEQFw=s900-c-k-c0xffffffff-no-rj-mo","Sociedad Androide","Android Youtube Channel"),
        User("https://bogsoftware.com/wp-content/uploads/2014/07/1024px-Breezeicons-apps-48-android-studio.svg_.png","Android Studio","Your favorite IDE"),
        User("https://4.bp.blogspot.com/-NnAkV5vpYuw/XNMYF4RtLvI/AAAAAAAAI70/kdgLm3cnTO4FB4rUC0v9smscN3zHJPlLgCLcBGAs/s1600/Jetpack_logo%2B%25282%2529.png","JetExample","Star the repo if it helped ;)")))
}