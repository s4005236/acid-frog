package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.ProfileDetailScreen
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProfileImportScreen(
    navController: NavController,
    dataString: String,
    viewModel: ProfileImportViewModel = hiltViewModel(),
) {
    viewModel.importProfileByDataString(dataString)

    if(viewModel.state.value.importedProfileId > 0L) {
        navController.navigate(ProfileDetailScreen(viewModel.state.value.importedProfileId))
    }
}
