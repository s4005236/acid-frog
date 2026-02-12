package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.presentation.screens.profile_list.components.FloatingActionButtonProfileList
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.components.ProfileListItem
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.components.TopBarProfileList
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProfileManagementScreen(
    navController: NavController,
    viewModel: ProfileListViewModel = hiltViewModel()
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(state.profiles) { profile ->
                    ProfileListItem(profile = profile, onItemClick = {
                        //TODO navigate to detail screen by Id
                    })
                }
            }
        }
    }

}
