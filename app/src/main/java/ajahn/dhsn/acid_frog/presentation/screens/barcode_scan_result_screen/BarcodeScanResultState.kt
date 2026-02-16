package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.model.AppProduct

data class BarcodeScanResultState(
    val isLoading: Boolean = false,
    val appProduct: AppProduct? = null,
    val error: String = ""
)
