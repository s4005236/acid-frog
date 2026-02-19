package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_screen

import ajahn.dhsn.acid_frog.BarcodeScanResultScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

@Composable
fun BarcodeScanScreen(
    navController: NavController
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.safeDrawingPadding()
    ) {
        val scanOptions = GmsBarcodeScannerOptions.Builder()
        .enableAutoZoom()
        .setBarcodeFormats(
            //european barcodes long
            Barcode.FORMAT_EAN_13,
            //european barcodes short
            Barcode.FORMAT_EAN_8,
            //north america barcodes long
            Barcode.FORMAT_UPC_A,
            //north america barcodes short
            Barcode.FORMAT_UPC_E
        )
        .build()

        val barcodeScanner = GmsBarcodeScanning.getClient(context, scanOptions)

        barcodeScanner.startScan()
            .addOnSuccessListener { barcode ->
                val barcodeString = barcode.rawValue ?: "null"
                navController.navigate(BarcodeScanResultScreen(barcode = barcodeString))
            }
            .addOnCanceledListener {
                // Task canceled
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
            }

    }
}
