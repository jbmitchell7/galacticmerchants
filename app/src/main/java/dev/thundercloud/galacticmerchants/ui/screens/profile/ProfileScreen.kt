package dev.thundercloud.galacticmerchants.ui.screens.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.thundercloud.galacticmerchants.R
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Text(text = stringResource(R.string.profile))
}