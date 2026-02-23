package ajahn.dhsn.acid_frog.domain.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * Data class representing a user profile in the application.
 *
 * This class holds profile details such as ID, name, allergens, and activity status.
 * It uses [MutableState] for state management, allowing reactive updates in composable UI components.
 *
 * @property id The unique identifier of the profile, wrapped in a [MutableState].
 * @property name The name of the user, wrapped in a [MutableState].
 * @property allergens A mutable list of allergens associated with the user.
 * @property isActive Indicates whether the profile is active, wrapped in a [MutableState].
 */
data class AppProfile(
    val id: MutableState<Long> = mutableStateOf(0L),
    var name: MutableState<String> = mutableStateOf(""),
    var allergens: MutableList<String> = mutableListOf(),
    var isActive: MutableState<Boolean> = mutableStateOf(false),
)
