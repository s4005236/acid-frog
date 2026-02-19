package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun BarcodeScanResultScreen(
    navController: NavController,
    viewModel: BarcodeScanResultViewModel = hiltViewModel(),
    barcode: String
) {
    viewModel.getAppScanResult(barcode)
    val state = viewModel.state.value

    val context = LocalContext.current

    Box(
        modifier = Modifier.safeDrawingPadding()
    ) {
        Column {
            Text("Hier erscheinen alle bereitzustellenden informationen")
            Text("Placeholder: ${state.scanResult?.id}")
        }


        if(state.error.isNotBlank()) {
            //val state = null
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
