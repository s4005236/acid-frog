package ajahn.dhsn.acid_frog.presentation.screens.profile_list.components

import ajahn.dhsn.acid_frog.presentation.theme.Typography
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarProfileList(){
    CenterAlignedTopAppBar(title = { Text(text= "Profile verwalten", style= Typography.headlineLarge) }, actions = {
            IconButton(onClick = { /* TODO: missing functionality, remove button if not needed */ }) {
            }
        })
}