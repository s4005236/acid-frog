package ajahn.dhsn.acid_frog.domain.model

data class AppScanResult (
    val profileCount : Int = 0,
    val scanResultMap : Map<String, List<AppProfile>> = emptyMap(),
    val appProduct: AppProduct = AppProduct()
)