package com.example.epass.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.epass.Auth.Login
import com.example.epass.Auth.Signup
import com.example.epass.screen.HomeScreen


@Composable
fun AppNavHost(
    modefier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.login.route
) {
    var context = LocalContext.current
    NavHost(
        modifier = modefier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.login.route) {
            Login(context = context, Navcontroller = navController)
        }
        composable(NavigationItem.signup.route) {
            Toast.makeText(context, "Signup nevigation", Toast.LENGTH_SHORT).show()
            Signup(context = context, Navcontroller = navController)
        }
        composable(NavigationItem.home.route) {
            HomeScreen()
        }
    }
}

