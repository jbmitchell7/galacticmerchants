package dev.thundercloud.galacticmerchants.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.thundercloud.galacticmerchants.R
import dev.thundercloud.galacticmerchants.model.navigation.NavigationItem

@Composable
fun BottomNavigation(navController: NavController) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val navRoutes = listOf(
        NavigationItem(
            title = stringResource(R.string.server_status),
            icon = R.drawable.network_check,
            route = Screen.Status.route
        ),
        NavigationItem(
            title = stringResource(R.string.profile),
            icon = R.drawable.id_card,
            route = Screen.Profile.route
        )
    )

    NavigationBar() {
        navRoutes.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route)
                },
                label = {
                    Text(item.title)
                },
                icon = {
                    Icon(imageVector = ImageVector.vectorResource(item.icon), contentDescription = "${item.title} icon")
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavPreview() {
    val navController = rememberNavController()
    BottomNavigation(navController)
}
