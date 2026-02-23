package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.domain.model.AppProfile

/**
 * Data class representing the state of a profile import operation.
 *
 * This class encapsulates the loading status, the ID of the imported profile, and any error messages
 * that may occur during the import process. It is typically used in ViewModel implementations
 * to manage and expose the state of profile import operations to the UI.
 *
 * @property isLoading Indicates whether the import operation is currently in progress.
 * @property importedProfileId The ID of the profile that was successfully imported. `0L` if no profile was imported.
 * @property error A message describing any error that occurred during the import. Empty if no error occurred.
 */
data class ProfileImportState(
    val isLoading: Boolean = false,
    val importedProfileId: Long = 0L,
    val error: String = ""
)
