package ajahn.dhsn.acid_frog.presentation.screens.scan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ScanResultScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.safeDrawingPadding()
    ) {
        Text(text = "Scan Result Screen.")
    }
    //TODO implement scan result screen
}
