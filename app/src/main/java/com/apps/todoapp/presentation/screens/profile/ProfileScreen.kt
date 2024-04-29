package com.apps.todoapp.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.apps.todoapp.presentation.navigation.AuthRouteScreen
import com.apps.todoapp.presentation.screens.MainViewModel
import com.apps.todoapp.storage.UserDetails

@Composable
fun ProfileScreen(
    rootNavHostController: NavHostController,
    mainViewModel: MainViewModel = MainViewModel()
) {
    var username by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    mainViewModel.getRegisteredUser(UserDetails.username ?: "")
    mainViewModel.user.observe(LocalLifecycleOwner.current, Observer {
        username = it.username
        name = it.name
        gender = it.gender
        age = it.age
    })
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(text = "Profile", style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            color = MaterialTheme.colorScheme.primary
        ))
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Name : ${name}")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Username : ${username}")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Age : ${age}")
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Gender : ${gender}")
        Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = {
                rootNavHostController.navigate(AuthRouteScreen.SignInScreen.route) {
                    popUpTo(0)
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Logout", color = Color.White)
        }
    }
}