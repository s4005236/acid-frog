package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.domain.Profile

data class ProfileListState(
    val isLoading: Boolean = false,
    val profiles: List<Profile> = emptyList(),
    val error: String = ""
)
