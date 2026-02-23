package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.model.AppScanResult

data class BarcodeScanResultState(
    val isLoading: Boolean = false,
    val scanResult: AppScanResult? = null,
    val error: String = ""
)
