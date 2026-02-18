package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.ProfileListScreen
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.presentation.screens.home.components.TopBarHome
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.ProfileListScreen
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ProfileDetailScreen(
    navController: NavHostController,
    viewModel: ProfileDetailViewModel = hiltViewModel(),
    profileId: Long
) {
    viewModel.getProfile(profileId)

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val selectOptions = listOf("Alle aktivieren", "Alle deaktivieren")

    var profileId by remember { mutableStateOf(viewModel.state.value.appProfile?.id ?: 0L) }
    var profileName by remember {
        mutableStateOf(
            viewModel.state.value.appProfile?.name ?: ""
        )
    }
    var profileAllergenList by remember {
        mutableStateOf(
            viewModel.state.value.appProfile?.allergens ?: emptyList()
        )
    }
    var profileIsActive by remember {
        mutableStateOf(
            viewModel.state.value.appProfile?.isActive ?: false
        )
    }

    Scaffold(topBar = {
        TopBarHome("Profil bearbeiten")
    }, floatingActionButton = {
        ExtendedFloatingActionButton(
            onClick = {
                viewModel.saveProfile(
                    AppProfile(
                        id = profileId,
                        name = profileName,
                        allergens = profileAllergenList,
                        isActive = profileIsActive,
                    )
                )
                println(profileName)
                navController.navigate(ProfileListScreen)
            },
            icon = { Icon(Icons.Default.Add, "Save Profile") },
            text = { Text(text = "Profil speichern") },
        )
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Button(
                        onClick = { profileIsActive = !profileIsActive },
                        colors = if (profileIsActive) ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        else ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                    ) { Text(if (profileIsActive) "Profil aktiv" else "Profil inaktiv") }

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = profileName,
                        label = { Text("Profilname") },
                        placeholder = { Text("Name eintragen") },
                        onValueChange = { profileName = it },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            focusManager.clearFocus()
                        }),
                    )
                }
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
                        Text(text = "Bitte Zutaten auswählen:")
                        SingleChoiceSegmentedButtonRow(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            selectOptions.forEachIndexed { index, label ->
                                SegmentedButton(
                                    shape = SegmentedButtonDefaults.itemShape(
                                        index = index,
                                        count = selectOptions.size
                                    ),
                                    onClick = {},
                                    selected = false,
                                    label = { Text(label) }
                                )
                            }
                        }
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(minSize = 128.dp),
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(viewModel.state.value.allergens) { allergen ->
                                Button(
                                    onClick = {
                                        if (profileAllergenList.contains(allergen)) {
                                            profileAllergenList -= allergen
                                        } else {
                                            profileAllergenList += allergen
                                        }
                                    },
                                    modifier = Modifier.padding(2.dp),
                                    colors = if (profileAllergenList.contains(allergen))
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