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

/**
 * Composable floating action button for profile list actions.
 *
 * This component provides a toggleable floating action button that expands to show options
 * for adding a new profile or importing a profile. It is typically used in profile list screens
 * to provide quick access to profile creation and import features.
 *
 * @param navController The [NavController] for handling navigation to other screens.
 */
@Composable
fun ProfileListFloatingActionButton(
    navController: NavController,
) {
    // State to control the visibility of the expanded action buttons
    var toggleVisibility by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.End
    ) {
        // Animated visibility for the expanded action buttons
        AnimatedVisibility(
            visible = toggleVisibility,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically(),
            label = "Animated Toolbar",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Button for adding a new profile
                    Button(
                        onClick = {
                            // TODO: Navigate to add profile screen
                        },
                    ) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Add Profile", modifier = Modifier.padding(8.dp))
                        Text("Hinzufügen")
                    }

                    // Button for importing a profile
                    Button(
                        onClick = {
                            // TODO: Navigate to import profile screen
                        }
                    ) {
                        Icon(Icons.Default.Email, contentDescription = "Add Profile", modifier = Modifier.padding(8.dp))
                        Text("Importieren")
                    }
                }
            }
        )

        // Main floating action button to toggle visibility
        FloatingActionButton(
            onClick = {
                toggleVisibility = !toggleVisibility
            }) {
            Icon(Icons.Default.Add, "New Profile")
        }
    }
}
