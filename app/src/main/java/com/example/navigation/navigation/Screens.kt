package com.example.navigation.navigation


sealed class Screens(
    val route: String,
) {
    data object Registration: Screens(route = "Registration")
    data object Dashboard: Screens(route = "Dashboard")
    data object Help: Screens(route = "Help")
    data object Entranz: Screens(route = "Entranz")



}