package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

@HiltViewModel
class ProfileDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val profileRepository: ProfileRepository
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
                    _state.value = state.value.copy(isLoading = true)

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

    fun getProfile(profileId: Long) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                val response = profileRepository.getProfileById(profileId)

                when (response) {
                    is ResponseWrapper.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            appProfile = response.data
                        )

                        println("ID: ${response.data?.id}")
                        println("Trying to save ${response.data?.name}")
                        println("This includes the allergens ${response.data?.allergens}")
                    }

                    is ResponseWrapper.Error -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            error = response.errorMessage ?: "An unexpected error occurred"
                        )
                    }
                }
            }
        }
    }

    fun saveProfile(appProfile: AppProfile?) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                if (appProfile == null) {
                    return@withContext
                }

                if (appProfile.id.value == 0L) {
                    val response = profileRepository.insertProfile(appProfile)
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                } else {
                    val response = profileRepository.updateProfile(appProfile)
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }

    fun deleteProfile(appProfile: AppProfile?){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                if (appProfile == null) {
                    return@withContext
                }

                profileRepository.deleteProfile(appProfile)

                _state.value = state.value.copy(
                    isLoading = false
                )
            }
        }
    }
}