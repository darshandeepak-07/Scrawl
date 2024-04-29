package com.apps.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.apps.todoapp.presentation.navigation.Graphs
import com.apps.todoapp.presentation.navigation.graph.RootGraph
import com.apps.todoapp.presentation.screens.signin.SignInScreen
import com.apps.todoapp.ui.theme.ToDoAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootGraph(
                        rootNavController = rememberNavController(),
                        startDestination = Graphs.AuthGraph
                    )
                }
            }

        }
    }
}

