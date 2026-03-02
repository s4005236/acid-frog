package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.ProfileDetailScreen
import ajahn.dhsn.acid_frog.ProfileListScreen
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.presentation.components.ConfirmationDialog
import ajahn.dhsn.acid_frog.presentation.screens.home.components.TopBarHome
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.components.ProfileListItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController


/**
 * Composable screen for displaying and managing a list of user profiles.
 *
 * This screen provides a list of profiles with options to:
 * - View and edit a profile.
 * - Toggle a profile's active status.
 * - Delete a profile.
 * - Add a new profile.
 *
 * The screen uses a [Scaffold] with a top bar, a floating action button for adding new profiles,
 * and a lazy column to display the profile list. It also handles loading, empty, and error states.
 *
 * @param navController The [NavController] for handling navigation to other screens.
 * @param viewModel The [ProfileListViewModel] providing the profile list data and business logic.
 */
@Composable
fun ProfileListScreen(
    navController: NavController,
    viewModel: ProfileListViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    // State for deletion dialog visibility and the selected profile
    var deletionDialogVisible by remember { mutableStateOf(false) }
    var clickedProfile by remember { mutableStateOf(AppProfile()) }

    Scaffold(
        topBar = {
            TopBarHome(navController, "Profile verwalten")
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    // Navigate to add a new profile
                    navController.navigate(ProfileDetailScreen(profileId = 0L))
                },
                icon = { Icon(Icons.Default.Add, "Add Profile") },
                text = { Text(text = "Profil hinzufügen") }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Profile list
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.state.value.appProfiles) { profile ->
                    ProfileListItem(
                        appProfile = profile,
                        onItemClick = {
                            // Navigate to profile detail
                            navController.navigate(ProfileDetailScreen(profileId = profile.id.value))
                        },
                        onIsActiveToggle = {
                            // Toggle active status and save
                            val toggledIsActiveProfile = profile.copy(
                                isActive = mutableStateOf(!profile.isActive.value)
                            )
                            viewModel.saveProfile(toggledIsActiveProfile)
                            navController.navigate(ProfileListScreen)
                        },
                        onDeleteClick = {
                            // Show deletion dialog
                            deletionDialogVisible = true
                            clickedProfile = profile
                        }
                    )
                }
            }

            // Deletion confirmation dialog
            ConfirmationDialog(
                visible = deletionDialogVisible,
                infoMessage = buildAnnotatedString {
                    append("Soll das Profil\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(clickedProfile.name.value)
                    }
                    append("\nwirklich gelöscht werden?")
                },
                onConfirmation = {
                    // Delete profile and refresh UI
                    viewModel.deleteProfile(clickedProfile)
                    deletionDialogVisible = false
                    navController.navigate(ProfileListScreen)
                },
                onDismiss = {
                    deletionDialogVisible = false
                }
            )

            // Empty state
            if (viewModel.state.value.appProfiles.isEmpty() && !viewModel.state.value.error.isNotBlank()) {
                Text(
                    text = "Keine Profile vorhanden",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            // Error state
            if (viewModel.state.value.error.isNotBlank()) {
                Text(
                    text = viewModel.state.value.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            // Loading state
            if (viewModel.state.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}