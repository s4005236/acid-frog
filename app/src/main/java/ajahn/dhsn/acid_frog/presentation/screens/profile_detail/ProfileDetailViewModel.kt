package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.common.Constants
import ajahn.dhsn.acid_frog.domain.Profile
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ProfileDetailViewModel @Inject constructor(
    //TODO inject needed UseCases
    //private val getProfileUseCase: GetProfileUseCase
    savedStateHandle : SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ProfileDetailState())
    val state: State<ProfileDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PROFILE_ID)?.let { profileId ->
            getProfile(profileId)
        }

        println("test")
    }

    private fun getProfile(profileId: String) {

        //FIXME: this is a dummy list, change logic once domain layer is implemented

        val dummyProfile: Profile = Profile(profileId, "Alice", listOf("garlic", "cpu"), true)

        _state.value = ProfileDetailState(profile = dummyProfile)
    }
}