package ajahn.dhsn.acid_frog.domain.model

data class AppProfile (
    val id: String,
    val profileName: String,
    val allergens: List<String>,
    val isActive : Boolean
)
