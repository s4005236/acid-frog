package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileDetailViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun BarcodeScanResultScreen(
    navController: NavController,
    viewModel: BarcodeScanResultViewModel = hiltViewModel(),
    barcode : String
) {
    viewModel.getProduct(barcode)
    val state = viewModel.state.value
    val context = LocalContext.current

    val product by remember { mutableStateOf(state.product) }

    Box(
        modifier = Modifier.safeDrawingPadding()
    ) {
        Column {
            Text("Gescannter Barcode: ${barcode}")

            Text("Hier müssen die Ergebnisse der Analyse angezeigt werden.")

            Text(product?.name ?: "kein Produkt gefunden")
        }
    }
}
