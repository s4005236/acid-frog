package ajahn.dhsn.acid_frog.domain

data class Profile (
    val id: String,
    val profileName: String,
    val ingredients: List<Ingredient>,
    val isActive : Boolean
)
