package com.android.sampleapplication1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.sampleapplication1.Screen
import com.android.sampleapplication1.screens.LandingScreen

@Composable
fun Navigation(){
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = Screen.Landing.route){
        composable(route = Screen.Landing.route) {
            LandingScreen(navController)
        }
        composable(route = Screen.Dashboard.route) {

        }
        composable(route = Screen.Product.route) {

        }
    }
}