package dev.thundercloud.galacticmerchants.navigation

sealed class Screen(val route: String) {
    object Profile: Screen("profile_screen")
    object Status: Screen("status_screen")
}