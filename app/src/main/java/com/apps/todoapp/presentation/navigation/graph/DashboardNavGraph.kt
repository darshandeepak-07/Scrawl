package com.apps.todoapp.presentation.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apps.todoapp.presentation.navigation.DashRouteScreen
import com.apps.todoapp.presentation.navigation.Graphs
import com.apps.todoapp.presentation.screens.dashboard.screens.HomeScreen
import com.apps.todoapp.presentation.screens.dashboard.screens.MessageScreen
import com.apps.todoapp.presentation.screens.profile.ProfileScreen

@Composable
fun DashboardNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    padding  :PaddingValues
) {
    NavHost(
        navController = homeNavController,
        route = Graphs.DashboardGraph,
        startDestination = DashRouteScreen.Home.route
    ) {
        composable(route = DashRouteScreen.Home.route) {
            HomeScreen(rootNavController,padding)
        }
        composable(route = DashRouteScreen.Messages.route) {
            MessageScreen(rootNavController)
        }

    }
}