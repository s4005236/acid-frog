package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.common.Constants
import ajahn.dhsn.acid_frog.domain.Ingredient
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
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ProfileDetailState())
    val state: State<ProfileDetailState> = _state

    init {
    }

    fun getProfile(profileId: String) {

        //FIXME: this is a dummy element, change logic once domain layer is implemented

        val dummyProfile: Profile = Profile(
            "1", "Alice", listOf(
                Ingredient(id = "1", ingredientName = "pepper", isActive = true),
                Ingredient(id = "2", ingredientName = "basil", isActive = true),
                Ingredient(id = "3", ingredientName = "carrot", isActive = false),
                Ingredient(id = "4", ingredientName = "parsley", isActive = true),
                Ingredient(id = "5", ingredientName = "celery", isActive = false),
            ), true
        )

        _state.value = ProfileDetailState(profile = dummyProfile)
    }

    fun createProfile(){

    }

    fun updateProfile(profileId: String){

    }
}