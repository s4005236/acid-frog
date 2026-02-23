package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.domain.model.AppProfile

data class ProfileImportState(
    val isLoading: Boolean = false,
    val importedProfileId: Long = 0L,
    val error: String = ""
)
