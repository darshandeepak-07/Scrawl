package com.apps.todoapp.presentation.screens.dashboard.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.apps.todoapp.presentation.screens.components.CustomTextField
import com.apps.todoapp.R
import com.apps.todoapp.domain.model.Thought
import com.apps.todoapp.presentation.screens.components.ThoughtCard
import com.apps.todoapp.storage.UserDetails

@Composable
fun HomeScreen(
    rootNavController: NavHostController,
    paddingValues: PaddingValues,
    homeScreenViewModel: HomeScreenViewModel = HomeScreenViewModel()
) {
    var thought by remember { mutableStateOf("") }
    homeScreenViewModel.getThoughts()
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.White)
    ){
        Spacer(modifier = Modifier.height(10.dp))

            TextField(
                placeholder = {
                    Text(text = "Share your thought..", color = Color.LightGray)
                },
                value = thought,
                onValueChange = {
                    thought = it
                },
                shape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape),
                trailingIcon = {
                    IconButton(
                        onClick = {
                                  homeScreenViewModel.addThought(Thought(thought = thought, createdBy = UserDetails.username ?: ""))
                                thought = ""
                        },
                        modifier = Modifier.size(24.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = null
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                    focusedPlaceholderColor = Color.Transparent,
                    unfocusedPlaceholderColor = Color.LightGray
                )

            )
        Column (
            modifier = Modifier.verticalScroll(rememberScrollState())
        ){
            homeScreenViewModel.thoughts.value?.forEach {
                ThoughtCard(
                    creator = it.createdBy,
                    thought = it.thought
                )
            }
            homeScreenViewModel.getThoughts()
        }
        }
    
}
