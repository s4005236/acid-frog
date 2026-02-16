package ajahn.dhsn.acid_frog.domain.model

data class AppProfile (
    val id: String,
    val profileName: String,
    val appIngredients: List<AppIngredient>,
    val isActive : Boolean
)
