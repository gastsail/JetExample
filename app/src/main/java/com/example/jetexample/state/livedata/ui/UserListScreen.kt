package com.example.jetexample.state.livedata.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.EmphasisAmbient
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideEmphasis
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.TextUnit
import com.example.jetexample.utils.showMessage

/**
 * [EN]
 * UserListScreen is a UI class that holds how each row should be displayed
 * and generates a list of Users based on the data that comes from a ViewModel.
 * We only expose the UserScreen implementation which is the responsable of draw the entire list
 * of users.
 */

/**
 *[ES]
 * UserListScreen es una pantalla de UI que contiene cada elemento que mostramos en pantalla
 * y genera una lista de Usuarios basado en la información provista por el ViewModel.
 * Solo exponemos el metodo UserScreen que es el encargado de dibujar en pantalla la lista de usuarios.
 */

@Composable
private fun UserRow(user:User,onUserClick: (User) -> Unit) {
    Row(modifier = Modifier.clickable(onClick = { onUserClick(user) }).fillMaxWidth().padding(8.dp)) {
        val imageModifier = Modifier.preferredSize(46.dp).clip(shape = CircleShape)
        val image = imageResource(id = R.drawable.header)
        Image(asset = image,modifier = imageModifier,contentScale = ContentScale.Crop)
        Column (modifier = Modifier.padding(start = 8.dp).gravity(Alignment.CenterVertically)){
            Text(text = user.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6)
            ProvideEmphasis(EmphasisAmbient.current.medium) {
                Text(text = user.bio,style = MaterialTheme.typography.body2)
            }

        }
    }
}

@Composable
private fun UserList(userList:List<User>){
    val context = ContextAmbient.current
    LazyColumnFor(items = userList) { user ->
        UserRow(user = user,onUserClick = {
            showMessage(context,"You clicked ${user.name}")
        })
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
    UserRow(User("WIP_COIL","Jet Example","Dont forget to star the repo ;)"),onUserClick = {})
}