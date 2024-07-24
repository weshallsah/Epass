package com.example.epass.View.component


enum class Screen {
    Login,
    Signup,
    Home,
    Profile
}

sealed class NavigationItem(val route: String) {
    object login : NavigationItem(Screen.Login.name)
    object signup : NavigationItem(Screen.Signup.name)
    object home : NavigationItem(Screen.Home.name)
    object profile : NavigationItem(Screen.Profile.name)
}