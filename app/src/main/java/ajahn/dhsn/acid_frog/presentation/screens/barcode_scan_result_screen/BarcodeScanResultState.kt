package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.Product

data class BarcodeScanResultState(
    val isLoading: Boolean = false,
    val product: Product? = null,
    val error: String = ""
)
