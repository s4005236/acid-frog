package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.domain.model.AppProfile

/**
 * Data class representing the state of a profile detail operation.
 *
 * This class encapsulates the loading status, list of allergens, profile data, and any error messages
 * that may occur during profile operations. It is typically used in ViewModel implementations
 * to manage and expose the state of profile detail operations to the UI.
 *
 * @property isLoading Indicates whether a profile operation is currently in progress.
 * @property allergens The list of allergens available for selection in the profile.
 * @property appProfile The profile being edited or viewed. `null` if not yet loaded or in case of error.
 * @property error A message describing any error that occurred during the operation. Empty if no error occurred.
 */
data class ProfileDetailState(
    val isLoading: Boolean = false,
    val allergens: List<String> = emptyList(),
    val appProfile: AppProfile? = null,
    val error: String = ""
)
