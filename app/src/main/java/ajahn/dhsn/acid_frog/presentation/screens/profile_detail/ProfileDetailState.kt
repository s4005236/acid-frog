package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.domain.model.AppProfile

data class ProfileDetailState(
    val isLoading: Boolean = false,
    val appProfile: AppProfile? = null,
    val error: String = ""
)
