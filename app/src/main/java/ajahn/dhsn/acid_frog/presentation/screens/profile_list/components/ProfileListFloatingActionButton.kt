package ajahn.dhsn.acid_frog.presentation.screens.profile_list.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileListFloatingActionButton(
    navController: NavController,

    ) {
    var toggleVisibility by remember { mutableStateOf(false) }


//    navController.navigate(ProfileDetailScreen(
//        profileId = 0L
//    ))

    Column(
        horizontalAlignment = Alignment.End
    ){
        AnimatedVisibility(
            visible = toggleVisibility,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically(),
            label = "Animated Toolbar",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Button(
                        onClick = {},
                    ){
                        Icon(Icons.Default.AccountCircle, contentDescription = "Add Profile", modifier = Modifier.padding(8.dp))
                        Text("Hinzufügen")
                    }

                    Button(
                        onClick = {}
                    ){
                        Icon(Icons.Default.Email, contentDescription = "Add Profile", modifier = Modifier.padding(8.dp))
                        Text("Importieren")}
                }
            }
            )

        FloatingActionButton(
            onClick = {
                toggleVisibility = !toggleVisibility
            }) {
            Icon(Icons.Default.Add, "New Profile")
        }
    }
}
