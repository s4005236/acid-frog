package ajahn.dhsn.acid_frog.presentation.screens.home.components

import ajahn.dhsn.acid_frog.presentation.theme.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome(
    topBarTitle: String
){
    CenterAlignedTopAppBar(title = { Text(text= topBarTitle, style= Typography.headlineMedium) },
        navigationIcon = {
            IconButton(onClick = { /* TODO: missing functionality, remove button if not needed */ }) {
                Icon(
                    imageVector = Icons.Default.Home, contentDescription = "Navigate Home"
                )
            }
        },

        actions = {
            IconButton(onClick = { /* TODO: missing functionality, remove button if not needed */ }) {
                Icon(
                    imageVector = Icons.Default.Settings, contentDescription = "Settings"
                )
            }
        })
}