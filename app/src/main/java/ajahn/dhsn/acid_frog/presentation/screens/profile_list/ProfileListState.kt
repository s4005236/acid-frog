package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.domain.model.AppProfile

/**
 * Data class representing the state of a profile list operation.
 *
 * This class encapsulates the loading status, the list of profiles, and any error messages
 * that may occur during profile list operations. It is typically used in ViewModel implementations
 * to manage and expose the state of profile list operations to the UI.
 *
 * @property isLoading Indicates whether the profile list operation is currently in progress.
 * @property appProfiles The list of profiles retrieved from the repository. Empty if no profiles are available.
 * @property error A message describing any error that occurred during the operation. Empty if no error occurred.
 */
data class ProfileListState(
    val isLoading: Boolean = false,
    val appProfiles: List<AppProfile> = emptyList(),
    val error: String = ""
)
