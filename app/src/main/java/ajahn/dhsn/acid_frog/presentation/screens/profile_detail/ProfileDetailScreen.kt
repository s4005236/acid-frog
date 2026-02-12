package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.presentation.screens.profile_list.components.FloatingActionButtonProfileList
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.components.TopBarProfileList
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProfileDetailScreen(
    navController: NavController,
    viewModel: ProfileDetailViewModel = hiltViewModel(),
    profileId: String
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopBarProfileList()
        },
        floatingActionButton = {
            FloatingActionButtonProfileList()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Text(text="Profiledetailscreen: ${profileId}")
        }
    }

}
