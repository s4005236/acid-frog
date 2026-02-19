package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class ProfileListViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileListState())
    val state: State<ProfileListState> = _state

    init {
        getProfiles()
    }

    private fun getProfiles() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(isLoading = true)

                val response = profileRepository.getAll()

                when (response) {
                    is ResponseWrapper.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            appProfiles = response.data ?: emptyList()
                        )
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

    //TODO twin of saveProfile in DetailViewModel, maybe put into Use Case?
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

    fun deleteProfile(appProfile: AppProfile?) {
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

    fun deleteAllProfiles() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                profileRepository.deleteAll()

                _state.value = state.value.copy(
                    isLoading = false
                )
            }
        }
    }
}