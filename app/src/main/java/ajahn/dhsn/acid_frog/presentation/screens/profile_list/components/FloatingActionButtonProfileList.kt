package ajahn.dhsn.acid_frog.presentation.screens.profile_list.components

import ajahn.dhsn.acid_frog.presentation.theme.Typography
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

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