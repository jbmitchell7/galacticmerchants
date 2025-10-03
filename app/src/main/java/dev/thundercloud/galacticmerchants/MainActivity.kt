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

//@Composable
//fun AppTitle(modifier: Modifier = Modifier) {
//    Text(
//        text = stringResource(R.string.app_name),
//        fontSize = 30.sp,
//        lineHeight = 35.sp,
//        modifier = modifier
//            .padding(15.dp)
//    )
//}
//
//@Composable
//fun AppLogo() {
//    val image = painterResource(R.drawable.logo)
//    Image(
//        painter = image,
//        contentDescription = null
//    )
//}
//
//@Composable
//fun AppShell(modifier: Modifier = Modifier) {
//    Box(
//        modifier
//            .fillMaxSize()
//    ) {
//        Row(
//            modifier
//                .padding(10.dp)
//                .height(70.dp)
//        ) {
//            AppLogo()
//            AppTitle(modifier)
//        }
//    }
//}
