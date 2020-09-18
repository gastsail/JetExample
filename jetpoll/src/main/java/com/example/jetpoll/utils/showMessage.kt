package com.example.jetpoll.utils

import android.content.Context
import android.widget.Toast

fun showMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}