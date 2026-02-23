package ajahn.dhsn.acid_frog.domain.model

import kotlinx.serialization.Serializable

/**
 * Data class representing a serializable version of an appProfile.
 *
 * This class is designed to be serialized and shared across different platforms or components.
 * It contains essential profile information such as ID, name, allergens, and activity status.
 * The `@Serializable` annotation enables automatic serialization/deserialization.
 *
 * @property id The unique identifier of the profile.
 * @property name The name of the user.
 * @property allergens A list of allergens associated with the user.
 * @property isActive Indicates whether the profile is currently active.
 */
@Serializable
data class SharableAppProfile(
    val id: Long = 0L,
    var name: String = "",
    var allergens: List<String> = emptyList(),
    var isActive: Boolean = false
)
