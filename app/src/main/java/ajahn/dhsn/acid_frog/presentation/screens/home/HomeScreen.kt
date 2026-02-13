package ajahn.dhsn.acid_frog.presentation.screens.home

import ajahn.dhsn.acid_frog.BarcodeScanScreen
import ajahn.dhsn.acid_frog.ProfileListScreen
import ajahn.dhsn.acid_frog.presentation.screens.home.components.TopBarHome
import ajahn.dhsn.acid_frog.presentation.theme.Typography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * The standard or first-seen screen of the application, as defined in Navigation: [NavHost][ajahn.dhsn.acid_frog.MainActivity].
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopBarHome("Acid Frog")
        }) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(60.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Profile verwalten", style = Typography.titleLarge)
                    ElevatedButton(
                        onClick = {
                            navController.navigate(ProfileListScreen)
                        }, modifier = Modifier.size(200.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Manage Profiles",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Produkte scannen", style = Typography.titleLarge)
                    Button(
                        onClick = {
                            navController.navigate(BarcodeScanScreen)
                        }, modifier = Modifier.size(200.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Start Scanning",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }

            }
        }
    }
}