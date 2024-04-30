package com.apps.todoapp.presentation.screens.dashboard

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.apps.todoapp.presentation.navigation.bottomNavList
import com.apps.todoapp.presentation.navigation.graph.DashboardNavGraph
import com.apps.todoapp.presentation.screens.components.CustomBottomBar
import com.apps.todoapp.presentation.screens.components.CustomTopBar

@Composable
fun DashboardScreen(
    rootNavHostController: NavHostController,
    homeNavHostController : NavHostController = rememberNavController()
) {
    val navBackStackEntry by homeNavHostController.currentBackStackEntryAsState()
    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf { navBackStackEntry?.destination?.route }
    }
    Scaffold(
        topBar = {
            CustomTopBar(navController = rootNavHostController)
        },
        bottomBar = {
            currentRoute?.let {
                CustomBottomBar(items = bottomNavList,it) { currentRoute ->
                    homeNavHostController.navigate(currentRoute.route) {
                        homeNavHostController.graph.startDestinationRoute?.let { startDestination ->
                            popUpTo(startDestination) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    ) {  padding ->
        DashboardNavGraph(
            rootNavController = rootNavHostController,
            homeNavController = homeNavHostController,
            padding = padding
        )
    }
}