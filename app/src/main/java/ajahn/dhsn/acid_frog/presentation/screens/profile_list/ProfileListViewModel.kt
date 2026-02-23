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

/**
 * ViewModel responsible for managing a list of profiles, including fetching, saving, and deleting profiles.
 *
 * This ViewModel coordinates the retrieval of profile lists, handles profile operations,
 * and exposes the state of these operations to the UI through [state].
 *
 * @property profileRepository Repository for accessing and managing profile data.
 * @property state The current state of the profile list operation, exposed as a [State] object.
 */
@HiltViewModel
class ProfileListViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileListState())
    val state: State<ProfileListState> = _state

    init {
        // Fetch profiles on initialization
        getProfiles()
    }

    /**
     * Fetches the list of all profiles.
     *
     * This function retrieves the list of profiles from the repository and updates the state accordingly.
     */
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

    /**
     * Saves a profile, either by inserting a new profile or updating an existing one.
     *
     * @param appProfile The profile to save. If `null`, the operation is aborted.
     */
    fun saveProfile(appProfile: AppProfile?) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(isLoading = true)

                if (appProfile == null) {
                    return@withContext
                }

                if (appProfile.id.value == 0L) {
                    // Insert new profile
                    val response = profileRepository.insertProfile(appProfile)
                    _state.value = state.value.copy(isLoading = false)
                } else {
                    // Update existing profile
                    val response = profileRepository.updateProfile(appProfile)
                    _state.value = state.value.copy(isLoading = false)
                }
            }
        }
    }

    /**
     * Deletes a profile.
     *
     * @param appProfile The profile to delete. If `null`, the operation is aborted.
     */
    fun deleteProfile(appProfile: AppProfile?) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(isLoading = true)

                if (appProfile == null) {
                    return@withContext
                }

                profileRepository.deleteProfile(appProfile)
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }

    /**
     * Deletes all profiles.
     *
     * Use with caution, as this operation is irreversible.
     */
    fun deleteAllProfiles() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(isLoading = true)

                profileRepository.deleteAll()
                _state.value = state.value.copy(isLoading = false)
            }
        }
    }
}
