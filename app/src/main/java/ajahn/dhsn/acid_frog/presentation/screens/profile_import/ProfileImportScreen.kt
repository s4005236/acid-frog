package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.ProfileDetailScreen
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController

/**
 * Composable screen for importing a profile from a shared data string.
 *
 * This screen processes the provided data string to import a profile and navigates to the profile detail screen
 * upon successful import. It uses [ProfileImportViewModel] to handle the import logic.
 *
 * @param navController The [NavController] for handling navigation to the profile detail screen.
 * @param dataString The encoded data string containing the profile to import.
 * @param viewModel The [ProfileImportViewModel] providing the import logic and state.
 */
@Composable
fun ProfileImportScreen(
    navController: NavController,
    dataString: String,
    viewModel: ProfileImportViewModel = hiltViewModel(),
) {
    // Import the profile using the provided data string
    viewModel.importProfileByDataString(dataString)

    // Navigate to the profile detail screen if import was successful
    if (viewModel.state.value.importedProfileId > 0L) {
        navController.navigate(ProfileDetailScreen(viewModel.state.value.importedProfileId))
    }
}
