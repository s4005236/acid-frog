package ajahn.dhsn.acid_frog.presentation.screens.home.components

import ajahn.dhsn.acid_frog.HomeScreen
import ajahn.dhsn.acid_frog.presentation.theme.Typography
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome(
    navController: NavController,
    topBarTitle: String,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(text = topBarTitle, style = Typography.headlineMedium) },
        navigationIcon = {
            IconButton(onClick = { navController.navigate(HomeScreen) }) {
                Icon(
                    imageVector = Icons.Default.Home, contentDescription = "Navigate Home"
                )
            }
        },

        actions = actions
    )
}
