package dev.thundercloud.galacticmerchants.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ServerStatusScreen(
    serverStatusState: ServerStatusState,
    modifier: Modifier = Modifier
) {
    when (serverStatusState) {
        is ServerStatusState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is ServerStatusState.Success -> ResultScreen(
            serverStatusState.status, modifier = modifier.fillMaxWidth()
        )
        is ServerStatusState.Error -> ErrorScreen( modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {}

@Composable
fun ResultScreen(status: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = status)
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {}