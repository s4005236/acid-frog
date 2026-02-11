package ajahn.dhsn.acid_frog.domain

data class Profile(
    val profileId: String,
    val profileName: String,
    //TODO maybe securely define all valid ingredients for easier comparison
    val ingredients: List<String>
)
