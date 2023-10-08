package com.example.waterinquiry.navigation


import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.waterinquiry.presentation.HomeScreen
import com.example.waterinquiry.presentation.InfoScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeSreen.route) {
        composable(route = Screen.HomeSreen.route) {
            HomeScreen(navController)
        }

        composable(route = Screen.InfoScreen.route){
            InfoScreen(navController)
        }
    }
}
