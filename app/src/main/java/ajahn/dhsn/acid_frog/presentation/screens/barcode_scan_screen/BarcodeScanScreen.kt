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

/**
 * Composable screen for scanning barcodes using the device's camera.
 *
 * This screen initializes a barcode scanner with support for common barcode formats
 * (EAN-13, EAN-8, UPC-A, UPC-E) and navigates to the result screen upon successful scan.
 * It uses Google Mobile Services (GMS) for barcode scanning.
 *
 * @param navController The [NavController] for handling navigation to the result screen.
 */
@Composable
fun BarcodeScanScreen(
    navController: NavController
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.safeDrawingPadding()
    ) {
        // Configure barcode scanner options
        val scanOptions = GmsBarcodeScannerOptions.Builder().enableAutoZoom().setBarcodeFormats(
                // European barcodes (long)
                Barcode.FORMAT_EAN_13,
                // European barcodes (short)
                Barcode.FORMAT_EAN_8,
                // North American barcodes (long)
                Barcode.FORMAT_UPC_A,
                // North American barcodes (short)
                Barcode.FORMAT_UPC_E
            ).build()

        // Initialize barcode scanner
        val barcodeScanner = GmsBarcodeScanning.getClient(context, scanOptions)

        // Start barcode scanning
        barcodeScanner.startScan().addOnSuccessListener { barcode ->
                // Navigate to result screen with the scanned barcode
                val barcodeString = barcode.rawValue ?: "null"
                navController.navigate(BarcodeScanResultScreen(barcode = barcodeString))
            }.addOnCanceledListener {
                // Handle scan cancellation
            }.addOnFailureListener { e ->
                // Handle scan failure
            }
    }
}

