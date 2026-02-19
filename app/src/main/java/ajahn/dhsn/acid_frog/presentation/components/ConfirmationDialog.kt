package ajahn.dhsn.acid_frog.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ConfirmationDialog(
    visible: Boolean,
    infoMessage: AnnotatedString,
    onConfirmation: () -> Unit,
    onDismiss: () -> Unit,
) {
    if (visible) {
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding (20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ){
                Icon(Icons.Default.Info, contentDescription = "Info Icon", modifier = Modifier.padding(8.dp))

                Text(text = infoMessage, textAlign = TextAlign.Center)

                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    TextButton(
                        onClick = { onDismiss() },
                    ) {
                        Text("Abbrechen")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                    ) {
                        Text("Bestätigen")
                    }
                }
            }
            }
        }
    }
}