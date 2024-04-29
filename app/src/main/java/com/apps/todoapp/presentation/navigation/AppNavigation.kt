package com.apps.todoapp.presentation.navigation

enum class Screen {
    SIGNIN,
    REGISTER,
    DASHBOARD,
    HOME,
    MESSAGE,
    PROFILE
}
sealed class NavigationItem(val route: String) {
    data object SignInScreen : NavigationItem(Screen.SIGNIN.name)
    data object Dashboard : NavigationItem(Screen.DASHBOARD.name)
}