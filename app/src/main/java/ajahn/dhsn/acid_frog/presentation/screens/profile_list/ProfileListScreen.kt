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


@Composable
fun ProfileListScreen(
    navController: NavController,
    viewModel: ProfileListViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    var deletionDialogVisible by remember {mutableStateOf(false)}
    var clickedProfile by remember {mutableStateOf(AppProfile())}

    Scaffold(
        topBar = {
            TopBarHome(navController, "Profile verwalten")
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    navController.navigate(ProfileDetailScreen(
                        profileId = 0L
                    ))
                },
                icon = { Icon(Icons.Default.Add, "Add Profile") },
                text = { Text(text = "Profil hinzufügen") },
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(viewModel.state.value.appProfiles) { profile ->
                    ProfileListItem(appProfile = profile,
                        onItemClick = {
                        navController.navigate(ProfileDetailScreen(
                            profileId = profile.id.value
                        ))
                    },
                        onIsActiveToggle = {
                            val toggledIsActiveProfile = profile.copy(
                                isActive = mutableStateOf(!profile.isActive.value)
                            )
                            viewModel.saveProfile(toggledIsActiveProfile)
                            navController.navigate(ProfileListScreen)
                        },
                        onDeleteClick = {
                            deletionDialogVisible = true
                            clickedProfile = profile
                        }
                        )
                }
            }

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
                    viewModel.deleteProfile(clickedProfile)
                    deletionDialogVisible = false
                    //navigate for updating UI
                    navController.navigate(ProfileListScreen)
                },
                onDismiss = {
                    deletionDialogVisible = false
                }
            )

            if (viewModel.state.value.appProfiles.isEmpty() && !viewModel.state.value.error.isNotBlank()){
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

            if (viewModel.state.value.isLoading) {
                CircularProgressIndicator(modifier = Modifier
                    .align(Alignment.Center)
                )
            }
        }
    }
}
