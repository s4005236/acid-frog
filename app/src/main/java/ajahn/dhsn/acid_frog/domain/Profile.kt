package ajahn.dhsn.acid_frog.domain

data class Profile (
    val id: String,
    val profileName: String,
    val ingredients: List<String>,
    val isActive : Boolean
)
