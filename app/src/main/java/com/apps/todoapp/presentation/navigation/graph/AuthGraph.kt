package com.apps.todoapp.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.apps.todoapp.presentation.navigation.AuthRouteScreen
import com.apps.todoapp.presentation.navigation.Graphs
import com.apps.todoapp.presentation.screens.register.RegisterScreen
import com.apps.todoapp.presentation.screens.signin.SignInScreen

fun NavGraphBuilder.authNavGraph(
    rootNavHostController: NavHostController
){
    navigation(
        route = Graphs.AuthGraph,
        startDestination = AuthRouteScreen.SignInScreen.route,
        ){
        composable(route = AuthRouteScreen.SignInScreen.route){
            SignInScreen(navController = rootNavHostController)
        }
        composable(route = AuthRouteScreen.RegisterScreen.route){
            RegisterScreen(navHostController = rootNavHostController)
        }
    }
}