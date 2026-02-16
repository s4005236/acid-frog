package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.domain.model.AppIngredient
import ajahn.dhsn.acid_frog.domain.model.AppProfile
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

        val dummyAppProfileLists: List<AppProfile> = listOf(
            AppProfile("1", "Alice", listOf(
                AppIngredient(id = "1", ingredientName = "garlic", isActive = true),
                AppIngredient(id = "5", ingredientName = "salt", isActive = true)
            ), true),
            AppProfile("2", "Bob", emptyList(),false),
            AppProfile("3", "Cameron", emptyList(),true)
        )

        _state.value = ProfileListState(appProfiles = dummyAppProfileLists)
    }
}