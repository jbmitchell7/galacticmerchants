package dev.thundercloud.galacticmerchants.navigation

sealed class Screen(val route: String) {
    object Status: Screen("status_screen")
    object Profile: Screen("profile_screen")
}