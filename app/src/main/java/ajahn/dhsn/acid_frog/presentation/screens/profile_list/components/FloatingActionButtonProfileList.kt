package ajahn.dhsn.acid_frog.presentation.screens.profile_list.components

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingActionButtonProfileList(){
    val context = LocalContext.current

    ExtendedFloatingActionButton(
        onClick = {
            //TODO navigate to detail screen to create new profile
            Toast.makeText(context, "About to Create new profile", Toast.LENGTH_SHORT).show()
        },
        icon = { Icon(Icons.Default.Add, "Add Profile") },
        text = { Text(text = "Profil hinzufügen") },
    )
}