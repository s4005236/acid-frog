package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.domain.Profile

data class ProfileDetailState(
    val isLoading: Boolean = false,
    val profile: Profile? = null,
    val error: String = ""
)
