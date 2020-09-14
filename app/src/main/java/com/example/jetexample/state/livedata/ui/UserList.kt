package com.example.jetexample.state.livedata.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jetexample.R
import com.example.jetexample.state.livedata.data.model.User
import com.example.jetexample.state.livedata.presentation.UserViewModel
import com.example.jetexample.ui.typography
import androidx.compose.runtime.getValue

@Composable
private fun UserRow(user:User) {
    Row(modifier = Modifier.padding(8.dp)) {
        val imageModifier = Modifier.preferredSize(46.dp).clip(shape = CircleShape)
        val image = imageResource(id = R.drawable.header)
        Image(asset = image,modifier = imageModifier,contentScale = ContentScale.Crop)
        Column{
            Text(text = user.name,style = typography.h5.merge(TextStyle(fontWeight = FontWeight.Bold)))
            Text(text = user.bio)
        }
    }
}

@Composable
private fun UserList(userList:List<User>){
    LazyColumnFor(items = userList) { user ->
        UserRow(user = user)
        Divider()
    }
}

@Composable
fun UserScreen(userViewModel:UserViewModel){
    val items: List<User> by userViewModel.fetchUserList.observeAsState(listOf())
    UserList(userList = items)
}


@Preview(showBackground = true)
@Composable
fun UserRowPreview(){
    UserRow(User("","Gastón","Android Engineer"))
}