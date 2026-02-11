package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.domain.Profile
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ProfileListViewModel @Inject constructor(
    //TODO inject needed UseCases
    //private val getProfilesUseCase: GetProfilesUseCase
    //private val savedStateHandle : SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ProfileListState())
    val state: State<ProfileListState> = _state

    init {
        getProfiles()
        println(state)
        val x = 0
    }

    private fun getProfiles() {

        //FIXME: this is a dummy list, change logic once domain layer is implemented

        val dummyProfileList: List<Profile> = listOf(
            Profile("1", "Alice", listOf("garlic", "cpu"), true),
            Profile("2", "Bob", listOf("beef", "value"),false),
            Profile("3", "Cameron", listOf("wall", "paper",),true)
        )

        _state.value = ProfileListState(profiles = dummyProfileList)
    }
}