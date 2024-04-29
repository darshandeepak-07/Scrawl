package com.apps.todoapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apps.todoapp.presentation.navigation.DashRouteScreen
import com.apps.todoapp.presentation.navigation.Graphs
import com.apps.todoapp.presentation.screens.dashboard.DashboardScreen
import com.apps.todoapp.presentation.screens.profile.ProfileScreen

@Composable
fun RootGraph(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    startDestination: String = Graphs.AuthGraph
) {
    NavHost(
        modifier = modifier,
        route = Graphs.RootGraph,
        navController = rootNavController,
        startDestination = startDestination
    ) {
        authNavGraph(rootNavController)
        composable(route = Graphs.DashboardGraph){
            DashboardScreen(rootNavHostController = rootNavController)
        }
        composable(route = DashRouteScreen.Profile.route){
            ProfileScreen(rootNavController)
        }
    }

}