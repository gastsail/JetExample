package com.example.jetexample.state.livedata.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetexample.R
import com.example.jetexample.state.livedata.data.model.User
import com.example.jetexample.state.livedata.presentation.UserViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetexample.utils.Result
import com.example.jetexample.utils.showMessage
import dev.chrisbanes.accompanist.coil.CoilImage

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
private fun UserRow(user: User, onUserClick: (User) -> Unit) {
    Row(
        modifier = Modifier.clickable(onClick = { onUserClick(user) }).fillMaxWidth().padding(8.dp)
    ) {
        val imageModifier =
            Modifier.requiredSize(46.dp).shadow(elevation = 4.dp, shape = CircleShape)
                .background(color = Color.White, shape = CircleShape)
        CoilImage(
            data = user.profilePicutre,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)) {
            Text(
                text = user.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = user.bio, style = MaterialTheme.typography.body2)
            }

        }
    }
}

@Composable
private fun UserList(userList: List<User>) {
    val context = LocalContext.current
    LazyColumn {
        items(userList) { user ->
            UserRow(user = user, onUserClick = {
                showMessage(context, "You clicked ${user.name}")
            })
        }

        Divider()
    }
}

@Composable
fun UserScreen(userViewModel: UserViewModel) {
    val items: Result<List<User>> by userViewModel.fetchUserList.observeAsState(
        Result.Success(
            listOf()
        )
    )
    when (items) {
        is Result.Loading -> {
            ShowProgressDialog()
        }
        is Result.Success -> {
            if ((items as Result.Success<List<User>>).data.isNotEmpty()) {
                UserList(userList = (items as Result.Success<List<User>>).data)
            } else {
                ShowEmptyList()
            }
        }
        is Result.Failure -> {
            // [EN] Since its a synchronous call we do not handle exceptions
            // [ES] Ya que es una llamada syncrona no manejamos excepciones
        }
    }
}

@Composable
private fun ShowProgressDialog() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
        Text(text = "Loading...", modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
private fun ShowEmptyList() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_error_outline_24),
            contentDescription = "Baseline error outline"
        )
        Text(text = "There is no data", modifier = Modifier.padding(top = 8.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun UserRowPreview() {
    UserRow(User("", "Gastón Saillén", "Android Engineer"), onUserClick = {})
}