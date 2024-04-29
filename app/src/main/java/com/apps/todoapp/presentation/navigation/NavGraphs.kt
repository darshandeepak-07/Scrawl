package com.apps.todoapp.presentation.navigation

object Graphs {
    const val RootGraph = "rootGraph"
    const val AuthGraph = "authGraph"
    const val DashboardGraph = "dashboardGraph"
}

sealed class AuthRouteScreen(val route: String) {
    data object SignInScreen : AuthRouteScreen(Screen.SIGNIN.name)
    data object RegisterScreen : AuthRouteScreen(Screen.REGISTER.name)
}

sealed class DashRouteScreen(val route: String) {
    data object Home : DashRouteScreen(Screen.HOME.name)
    data object Messages : DashRouteScreen(Screen.MESSAGE.name)
    data object Profile : DashRouteScreen(Screen.PROFILE.name)
}
