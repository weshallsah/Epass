package com.example.epass.component


enum class Screen {
    Login,
    Signup,
    Home
}

sealed class NavigationItem(val route: String) {
    object login : NavigationItem(Screen.Login.name)
    object signup : NavigationItem(Screen.Signup.name)
    object home : NavigationItem(Screen.Home.name)
}