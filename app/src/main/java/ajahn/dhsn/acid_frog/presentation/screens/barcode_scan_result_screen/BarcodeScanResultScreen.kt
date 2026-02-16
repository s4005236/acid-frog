package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun BarcodeScanResultScreen(
    navController: NavController,
    viewModel: BarcodeScanResultViewModel = hiltViewModel(),
    barcode : String
) {
    viewModel.getProduct(barcode)

    val context = LocalContext.current

    val product by remember { mutableStateOf(viewModel.state.value.appProduct) }

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
