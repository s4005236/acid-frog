package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.domain.model.AppProfile

data class ProfileListState(
    val isLoading: Boolean = false,
    val appProfiles: List<AppProfile> = emptyList(),
    val error: String = ""
)
