package ajahn.dhsn.acid_frog.presentation.screens.scan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun BarcodeScanScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.safeDrawingPadding()
    ) {
        Text(text = "Barcode Scan Screen.")
    }
    //TODO implement barcode scan screen
}
