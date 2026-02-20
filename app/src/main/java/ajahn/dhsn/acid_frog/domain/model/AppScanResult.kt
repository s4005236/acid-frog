package ajahn.dhsn.acid_frog.domain.model

data class AppScanResult (
    //TODO add real properties after processing is done
    val profileCount : Int = 0,
    val scanResultMap : Map<String, List<AppProfile>> = emptyMap(),
    val appProduct: AppProduct = AppProduct()
)