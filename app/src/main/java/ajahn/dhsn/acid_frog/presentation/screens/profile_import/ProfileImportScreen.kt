package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileDetailViewModel
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ProfileImportScreen(
    navController: NavHostController,
    importData: String
) {
    Text(importData)

    //TODO put data as new profile
    //TODO navigate to Profile Detail View after profile was created
}
