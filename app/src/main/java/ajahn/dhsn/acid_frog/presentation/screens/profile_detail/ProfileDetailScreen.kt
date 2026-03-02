package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.ProfileListScreen
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.presentation.components.ConfirmationDialog
import ajahn.dhsn.acid_frog.presentation.screens.home.components.TopBarHome
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController

/**
 * Composable screen for viewing and editing a user profile.
 *
 * This screen allows users to:
 * - Toggle the profile's active status.
 * - Edit the profile name.
 * - Select allergens from a list.
 * - Delete or share the profile.
 *
 * The screen uses a [Scaffold] with a top bar, dropdown menu for actions, and a floating action button for saving.
 * It also handles loading and error states.
 *
 * @param navController The [NavHostController] for handling navigation.
 * @param viewModel The [ProfileDetailViewModel] providing the profile data and business logic.
 * @param profileId The ID of the profile to edit. If `0`, a new profile is created.
 */
@Composable
fun ProfileDetailScreen(
    navController: NavHostController,
    viewModel: ProfileDetailViewModel = hiltViewModel(),
    profileId: Long
) {
    // Fetch profile if not already loaded
    if (viewModel.state.value.appProfile == null) {
        viewModel.getProfile(profileId)
    }

    val state = viewModel.state.value
    var expanded by remember { mutableStateOf(false) }
    var deletionDialogVisible by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val selectOptions = listOf("Alle aktivieren", "Alle deaktivieren")

    // Local state for the profile being edited
    var appProfile by remember { mutableStateOf(AppProfile()) }

    // Initialize local profile state if needed
    if (profileId > 0 && appProfile.id.value < 1 && state.appProfile != null) {
        appProfile = state.appProfile!!
    }

    Scaffold(
        topBar = {
            TopBarHome(
                navController,
                "Profil bearbeiten",
                actions = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More options")
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .shadow(2.dp, clip = true)
                            .background(color = MaterialTheme.colorScheme.surface)
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.primary
                            )
                    ) {
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Delete profile"
                                )
                            },
                            text = { Text("Profil löschen") },
                            onClick = { deletionDialogVisible = true }
                        )
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Share,
                                    contentDescription = "Share profile"
                                )
                            },
                            text = { Text("Profil teilen") },
                            onClick = { viewModel.shareProfile(context, appProfile) }
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    viewModel.saveProfile(appProfile)
                    navController.navigate(ProfileListScreen)
                },
                icon = { Icon(Icons.Default.Done, "Save Profile") },
                text = { Text(text = "Profil speichern") }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Profile status and name section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Button(
                        onClick = { appProfile.isActive.value = !appProfile.isActive.value },
                        colors = if (appProfile.isActive.value)
                            ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        else
                            ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                    ) {
                        Text(if (appProfile.isActive.value) "Profil aktiv" else "Profil inaktiv")
                    }
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = appProfile.name.value,
                        label = { Text("Profilname") },
                        placeholder = { Text("Name eintragen") },
                        onValueChange = { appProfile.name.value = it },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
                    )
                }

                // Allergen selection section
                Box(
                    modifier = Modifier
                        .border(
                            2.dp,
                            MaterialTheme.colorScheme.primary,
                            RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(text = "Bitte Allergene auswählen:")
                        SingleChoiceSegmentedButtonRow(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            selectOptions.forEachIndexed { index, label ->
                                SegmentedButton(
                                    shape = SegmentedButtonDefaults.itemShape(
                                        index = index,
                                        count = selectOptions.size
                                    ),
                                    onClick = {
                                        if (index == 0) {
                                            // Activate all allergens
                                            appProfile = appProfile.copy(
                                                allergens = viewModel.state.value.allergens.toMutableList()
                                            )
                                        }
                                        if (index == 1) {
                                            // Deactivate all allergens
                                            appProfile = appProfile.copy(
                                                allergens = emptyList<String>().toMutableList()
                                            )
                                        }
                                    },
                                    selected = false,
                                    label = { Text(label) }
                                )
                            }
                        }
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(minSize = 128.dp),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(viewModel.state.value.allergens) { allergen ->
                                Button(
                                    onClick = {
                                        if (appProfile.allergens.contains(allergen)) {
                                            // Remove allergen if already contained
                                            appProfile = appProfile.copy(
                                                allergens = (appProfile.allergens - allergen).toMutableList()
                                            )
                                        } else {
                                            // Add allergen if not already contained
                                            appProfile = appProfile.copy(
                                                allergens = (appProfile.allergens + allergen).toMutableList()
                                            )
                                        }
                                    },
                                    modifier = Modifier.padding(2.dp),
                                    colors = if (appProfile.allergens.contains(allergen))
                                        ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                                    else
                                        ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                                ) {
                                    Text(allergen)
                                }
                            }
                        }
                    }
                }
            }

            // Deletion confirmation dialog
            ConfirmationDialog(
                visible = deletionDialogVisible,
                infoMessage = buildAnnotatedString {
                    append("Soll das Profil\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(appProfile.name.value)
                    }
                    append("\nwirklich gelöscht werden?")
                },
                onConfirmation = {
                    viewModel.deleteProfile(appProfile)
                    navController.navigate(ProfileListScreen)
                    deletionDialogVisible = false
                },
                onDismiss = {
                    deletionDialogVisible = false
                    expanded = false
                }
            )

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
