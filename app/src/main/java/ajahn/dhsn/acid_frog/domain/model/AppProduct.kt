package ajahn.dhsn.acid_frog.domain.model

data class AppProduct(
    val code : String = "",
    val status: Int = -1,
    val status_verbose: String = "",
    val name: String = "",
    val ingredients : List<String> = emptyList()
)

//TODO maybe put mutuableStateOf