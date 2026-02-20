package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.ProfileDetailScreen
import ajahn.dhsn.acid_frog.ProfileListScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileDetailViewModel
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.ProfileListScreen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun ProfileImportScreen(
    navController: NavController,
    importData: String,
    viewModel: ProfileImportViewModel = hiltViewModel(),
) {
    viewModel.importProfileByDataString(importData)
    navController.navigate(ProfileListScreen)
}
