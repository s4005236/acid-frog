package ajahn.dhsn.acid_frog.domain.model

/**
 * Data class representing the result of a product scan operation in the application.
 *
 * This class encapsulates the results of scanning a product, including the number of profiles
 * affected, a mapping of scan results to profiles, and the scanned product details.
 *
 * @property profileCount The number of profiles involved in the scan result.
 * @property scanResultMap A map where keys represent scan result identifiers and values are lists
 *                          of [AppProfile] objects associated with each result.
 * @property appProduct The [AppProduct] that was scanned, containing its details.
 */
data class AppScanResult(
    val profileCount: Int = 0,
    val scanResultMap: Map<String, List<AppProfile>> = emptyMap(),
    val appProduct: AppProduct = AppProduct()
)
