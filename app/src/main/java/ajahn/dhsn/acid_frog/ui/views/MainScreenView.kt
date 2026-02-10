package ajahn.dhsn.acid_frog.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Acid Frog") },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    }
                })
        }
        ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column() {
                val mainButtonSize = 200.dp

                FilledTonalIconButton(onClick = {
                    /* TODO: Link to profile management view */
                },
                    modifier = Modifier.size(mainButtonSize)) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Manage Profiles",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(mainButtonSize/10, mainButtonSize/10)
                    )
                }

                Spacer(modifier = Modifier.height(mainButtonSize/4))

                FilledIconButton(onClick = {
                    /* TODO: Link to scanning view */
                },
                    modifier = Modifier.size(mainButtonSize)) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Start Scanning",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(mainButtonSize/10, mainButtonSize/10)
                    )
                }
            }
        }
    }
}