package com.apps.todoapp.presentation.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.apps.todoapp.R
import com.apps.todoapp.domain.model.RegisterdUsers
import com.apps.todoapp.presentation.screens.MainViewModel
import com.apps.todoapp.presentation.screens.components.CustomButton
import com.apps.todoapp.presentation.screens.components.CustomTextField
import com.apps.todoapp.presentation.screens.components.GenderDropdown

@Composable
fun RegisterScreen(
    navHostController: NavHostController,
    mainViewModel: MainViewModel = MainViewModel()
) {
    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.story_map_o_svgrepo_com),
                    contentDescription = null, tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                text = "Scrawl",
                style = TextStyle(
                    fontWeight = FontWeight(600),
                    fontSize = 35.sp,
                    fontStyle = FontStyle(R.font.inter_black),
                    color = Color.Black
                )
            )
            Text(
                text = "Share your thoughts",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontStyle = FontStyle(R.font.inter_thin)
                ),
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Get your scrawl account",
            style = TextStyle(
                fontWeight = FontWeight(600),
                fontStyle = FontStyle(R.font.inter_extrabold),
                fontSize = 24.sp,
                color = Color.Black
            )
        )
        Text(
            text = "Few steps to become a scrawler",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
                fontStyle = FontStyle(R.font.inter_thin)
            ),
            modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        CustomTextField(
            keyboardType = KeyboardType.Password,
            labelText = "Name",
            value = name,
            onTextChange = {
                name = it
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomTextField(
            keyboardType = KeyboardType.Number,
            labelText = "Age",
            value = age,
            onTextChange = {
                age = it
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        GenderDropdown(selectedGender = "Male") {
            gender = it
        }
        CustomTextField(
            labelText = "Username",
            value = username,
            onTextChange = {
                username = it
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomTextField(
            keyboardType = KeyboardType.Password,
            labelText = "Password",
            value = password,
            onTextChange = {
                password = it
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(25.dp))
        CustomButton(
            buttonText = "Sign up",
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            if (username.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && age.isNotEmpty()) {
                mainViewModel.registerUser(
                    RegisterdUsers(
                        name = name,
                        username = username,
                        password = password,
                        age = age,
                        gender = gender
                    )
                )
                navHostController.popBackStack()
            }
        }

    }
}
