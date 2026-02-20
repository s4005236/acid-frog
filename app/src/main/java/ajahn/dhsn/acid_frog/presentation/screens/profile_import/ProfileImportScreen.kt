package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun ProfileImportScreen(
    navController: NavHostController,
    importData: String
) {
    Text(importData)



    //TODO extract from deep link

    //TODO put data as new profile
    //TODO navigate to Profile Detail View after profile was created
}
