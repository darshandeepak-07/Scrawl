package com.apps.todoapp.presentation.navigation

import com.apps.todoapp.R

val bottomNavList = listOf(
    BottomNavScreen(
        route = DashRouteScreen.Home.route,
        title = R.string.home,
        icon = R.drawable.ic_home_inactive,
        iconFocused = R.drawable.ic_home_active
    ),
    BottomNavScreen(
        route = DashRouteScreen.Messages.route,
        title = R.string.message,
        icon = R.drawable.ic_more_inactive,
        iconFocused = R.drawable.ic_more_active
    )
)