package dev.thundercloud.galacticmerchants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.thundercloud.galacticmerchants.ui.theme.GalacticMerchantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalacticMerchantsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppShell(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppTitle(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.app_name),
        fontSize = 30.sp,
        lineHeight = 35.sp,
        modifier = modifier
            .padding(15.dp)
    )
}

@Composable
fun AppLogo() {
    val image = painterResource(R.drawable.logo)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun AppShell(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
    ) {
        Row(
            modifier
                .padding(10.dp)
                .height(70.dp)
        ) {
            AppLogo()
            AppTitle(modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppHeaderPreview() {
    GalacticMerchantsTheme {
        AppShell()
    }
}
