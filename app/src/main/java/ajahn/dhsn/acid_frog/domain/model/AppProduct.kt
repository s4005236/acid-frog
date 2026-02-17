package ajahn.dhsn.acid_frog.domain.model

data class AppProduct(
    val id: String,
    val code : String,
    val status: Int,
    val status_verbose: String,
    val name: String,
    val ingredients : List<String>
)
