package ajahn.dhsn.acid_frog.presentation.screens.home

import ajahn.dhsn.acid_frog.presentation.screens.Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            CenterAlignedTopAppBar(title = { Text("Acid Frog") }, actions = {
                IconButton(onClick = { /* TODO: missing functionality, remove button if not needed */ }) {
                    Icon(
                        imageVector = Icons.Default.Settings, contentDescription = "Settings"
                    )
                }
            })
        }) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                val mainButtonSize = 200.dp
                val labelFontSize = 28.sp

                Column(
                    verticalArrangement = Arrangement.spacedBy(mainButtonSize / 10),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Profile verwalten", fontSize = labelFontSize)
                    FilledTonalIconButton(
                        onClick = {
                            navController.navigate(Screen.ProfileManagementScreen.route)
                        }, modifier = Modifier.size(mainButtonSize)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Manage Profiles",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(mainButtonSize / 10, mainButtonSize / 10)
                        )
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(mainButtonSize / 10),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Produkte scannen", fontSize = labelFontSize)
                    ElevatedButton(
                        onClick = {
                            navController.navigate(Screen.BarcodeScanScreen.route)
                        }, modifier = Modifier.size(mainButtonSize)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Start Scanning",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(mainButtonSize / 10, mainButtonSize / 10)
                        )
                    }
                }

            }
        }
    }
}