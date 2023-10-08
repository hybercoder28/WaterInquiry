package com.example.waterinquiry.navigation


sealed class Screen(val route: String) {

    object HomeSreen : Screen("home_screen")

    object InfoScreen : Screen("info_screen")

}