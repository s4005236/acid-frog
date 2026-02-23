package ajahn.dhsn.acid_frog.domain.model

import kotlinx.serialization.Serializable

/**
 * Class used for sharing AppProfiles over deep links.
 *
 * The mutableState of [AppProfile] makes it difficult to serialize the data. That's why this "twin" is used.
 */
@Serializable
data class SharableAppProfile(
    val id: Long = 0L,
    var name: String = "",
    var allergens: List<String> = emptyList(),
    var isActive: Boolean = false
)