package com.apps.todoapp.presentation.screens.signin

import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.apps.todoapp.R
import com.apps.todoapp.presentation.navigation.AuthRouteScreen
import com.apps.todoapp.presentation.navigation.Graphs
import com.apps.todoapp.presentation.screens.MainViewModel
import com.apps.todoapp.presentation.screens.components.CustomButton
import com.apps.todoapp.presentation.screens.components.CustomTextField
import com.apps.todoapp.storage.UserDetails

@Composable
fun SignInScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = MainViewModel()
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val lifecycle = LocalLifecycleOwner.current
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)){
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
            text = "Sign in",
            style = TextStyle(
                fontWeight = FontWeight(600),
                fontStyle = FontStyle(R.font.inter_extrabold),
                fontSize = 24.sp,
                color = Color.Black
            )
        )
        Text(
            text = "Welcome back Please enter your details below",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Black,
                fontStyle = FontStyle(R.font.inter_thin)
            ),
            modifier = Modifier.padding(top= 10.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
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
            buttonText = "Sign in",
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            mainViewModel.validateUser(username,password)
            mainViewModel.isValidated.observe(lifecycle, Observer {
                if(it){
                    UserDetails.username = username
                    navController.navigate(Graphs.DashboardGraph){
                        popUpTo(0)
                    }
                }else{
                    Toast.makeText(context,"User not authorised",Toast.LENGTH_SHORT).show()
                }
            })
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 12.dp)
        ) {
            Text(
                text =  "Get your new Scrawl Account  ",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(300),
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable {
                        navController.navigate(AuthRouteScreen.RegisterScreen.route)
                    },
                text = "Sign up",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
    }
}