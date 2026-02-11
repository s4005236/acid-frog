package ajahn.dhsn.acid_frog.presentation.screens.profile_list.components

import ajahn.dhsn.acid_frog.domain.Profile
import ajahn.dhsn.acid_frog.presentation.theme.Typography
import android.widget.ToggleButton
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun ProfileListItem(
    profile: Profile,
    onItemClick: (Profile) -> Unit
) {
    var isActiveButtonState by remember { mutableStateOf(profile.isActive) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(profile) }
            .padding(20.dp),
        horizontalArrangement = Arrangement
            .spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = isActiveButtonState,
            onCheckedChange = { isActiveButtonState = !isActiveButtonState },
        )

        Text(
            style = Typography.bodyLarge,
            text = "${profile.profileId} ${profile.profileName}",
        )
    }
}
