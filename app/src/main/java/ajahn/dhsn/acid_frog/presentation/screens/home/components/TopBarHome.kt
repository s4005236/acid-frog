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

/**
 * Composable function for a center-aligned top app bar with home navigation.
 *
 * This top bar displays a title, a home navigation button, and optional actions.
 * It is typically used as the top bar in screens that require navigation back to the home screen.
 *
 * @param navController The [NavController] for handling navigation to the home screen.
 * @param topBarTitle The title to display in the top bar.
 * @param actions Optional composable content to display as actions on the right side of the top bar.
 *                Defaults to an empty composable.
 */
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
                    imageVector = Icons.Default.Home,
                    contentDescription = "Navigate Home"
                )
            }
        },
        actions = actions
    )
}
