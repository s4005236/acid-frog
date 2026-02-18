package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

@HiltViewModel
class ProfileDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileDetailState())
    val state: State<ProfileDetailState> = _state

    init {
        getAllAllergens()
    }

    private fun getAllAllergens() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    _state.value = state.value.copy(
                        isLoading = true
                    )

                    val response = productRepository.getAllAllergens()

                    when (response) {
                        is ResponseWrapper.Success -> {
                            _state.value = state.value.copy(
                                isLoading = false,
                                allergens = response.data ?: emptyList()
                            )
                        }

                        is ResponseWrapper.Error -> {
                            _state.value = state.value.copy(
                                isLoading = false,
                                error = response.errorMessage ?: "An unexpected error occurred"
                            )
                        }
                    }


                } catch (e: HttpException) {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = e.localizedMessage ?: "An unexpected error occured"
                    )
                } catch (e: IOException) {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = "Couldn't reach server. Check your internet connection."
                    )
                }

            }
        }
    }

    fun getProfile(profileId: String) {

        //FIXME: this is a dummy element, change logic once domain layer is implemented

        val dummyAppProfile: AppProfile = AppProfile(
            "1", "Alice", listOf(
                "pepper",
                "basil",
                "carrot",
                "parsley",
                "celery",
            ), true
        )

        _state.value = state.value.copy(
            appProfile = dummyAppProfile
        )
    }

    fun saveProfile(profile: AppProfile) {
        //TODO implement and call profileRepository
        println("Trying to save ${profile.profileName}")
        println("This includes the allergens ${profile.allergens}")
    }
}