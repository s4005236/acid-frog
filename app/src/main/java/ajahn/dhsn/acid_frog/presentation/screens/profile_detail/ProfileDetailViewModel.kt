package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.domain.model.AppIngredient
import ajahn.dhsn.acid_frog.domain.model.AppProfile
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

        val dummyAppProfile: AppProfile = AppProfile(
            "1", "Alice", listOf(
                AppIngredient(id = "1", ingredientName = "pepper", isActive = true),
                AppIngredient(id = "2", ingredientName = "basil", isActive = true),
                AppIngredient(id = "3", ingredientName = "carrot", isActive = false),
                AppIngredient(id = "4", ingredientName = "parsley", isActive = true),
                AppIngredient(id = "5", ingredientName = "celery", isActive = false),
            ), true
        )

        _state.value = state.value.copy(
            appProfile = dummyAppProfile
        )
    }

    fun createProfile(){

    }

    fun updateProfile(profileId: String){

    }
}