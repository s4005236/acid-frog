package ajahn.dhsn.acid_frog.presentation.screens.profile_list.components

import ajahn.dhsn.acid_frog.HomeScreen
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.presentation.theme.Typography
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileListItem(
    appProfile: AppProfile,
    onItemClick: (AppProfile) -> Unit,
    onDeleteClick: (AppProfile) -> Unit,
    onIsActiveToggle: (AppProfile) -> Unit
) {
    var isActiveButtonState by remember { mutableStateOf(appProfile.isActive) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(appProfile) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement
            .spacedBy(20.dp)
        ){
            Switch(
                checked = appProfile.isActive.value,
                onCheckedChange = {
                    onIsActiveToggle(appProfile)
                                  },
            )

            Text(
                style = Typography.titleMedium,
                text = appProfile.name.value
            )
        }

        IconButton(onClick = { onDeleteClick(appProfile) }) {
            Icon(
                imageVector = Icons.Default.Delete, contentDescription = "Delete profile"
            )
        }
    }
}
