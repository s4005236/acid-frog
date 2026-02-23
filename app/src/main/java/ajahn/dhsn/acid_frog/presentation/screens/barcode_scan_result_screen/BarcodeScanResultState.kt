package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.model.AppScanResult

/**
 * Data class representing the state of a barcode scan result operation.
 *
 * This class encapsulates the loading status, scan result data, and any error messages
 * that may occur during the barcode scan process. It is typically used in ViewModel
 * implementations to manage and expose the state of scan operations to the UI.
 *
 * @property isLoading Indicates whether the scan operation is currently in progress.
 * @property scanResult The result of the scan operation, if successful. `null` if not yet available or in case of error.
 * @property error A message describing any error that occurred during the scan operation. Empty if no error occurred.
 */
data class BarcodeScanResultState(
    val isLoading: Boolean = false,
    val scanResult: AppScanResult? = null,
    val error: String = ""
)
