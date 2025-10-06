package dev.thundercloud.galacticmerchants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dev.thundercloud.galacticmerchants.ui.screens.ServerStatusScreen
import dev.thundercloud.galacticmerchants.ui.screens.ServerStatusViewModel
import dev.thundercloud.galacticmerchants.ui.theme.GalacticMerchantsTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalacticMerchantsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val serverStatusViewModel: ServerStatusViewModel = viewModel()
                    ServerStatusScreen(
                        serverStatusState = serverStatusViewModel.serverStatusState,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
