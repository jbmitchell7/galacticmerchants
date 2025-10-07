package dev.thundercloud.galacticmerchants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import dev.thundercloud.galacticmerchants.navigation.BottomNavigation
import dev.thundercloud.galacticmerchants.navigation.Screen
import dev.thundercloud.galacticmerchants.ui.screens.profile.ProfileScreen
import dev.thundercloud.galacticmerchants.ui.screens.serverstatus.ServerStatusScreen
import dev.thundercloud.galacticmerchants.ui.screens.serverstatus.ServerStatusViewModel
import dev.thundercloud.galacticmerchants.ui.theme.GalacticMerchantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalacticMerchantsTheme {
                ShellScreen()
            }
        }
    }
}

@Composable
fun ShellScreen() {

    val navController = rememberNavController()
    val serverStatusViewModel: ServerStatusViewModel = viewModel()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = { BottomNavigation(navController) }
    ) { innerPadding ->

        val graph =
            navController.createGraph(startDestination = Screen.Status.route) {
                composable(route = Screen.Status.route) {
                    ServerStatusScreen(
                        serverStatusState = serverStatusViewModel.serverStatusState,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable(route = Screen.Profile.route) {
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )

    }
}
