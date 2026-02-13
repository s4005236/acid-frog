package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.domain.Ingredient
import ajahn.dhsn.acid_frog.domain.Profile
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ProfileListViewModel @Inject constructor(
    //TODO inject needed UseCases
    //private val getProfilesUseCase: GetProfilesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProfileListState())
    val state: State<ProfileListState> = _state

    init {
        getProfiles()
    }

    private fun getProfiles() {

        //FIXME: this is a dummy list, change logic once domain layer is implemented

        val dummyProfileList: List<Profile> = listOf(
            Profile("1", "Alice", listOf(
                Ingredient(id = "1", ingredientName = "garlic", isActive = true),
                Ingredient(id = "5", ingredientName = "salt", isActive = true)
            ), true),
            Profile("2", "Bob", emptyList(),false),
            Profile("3", "Cameron", emptyList(),true)
        )

        _state.value = ProfileListState(profiles = dummyProfileList)
    }
}