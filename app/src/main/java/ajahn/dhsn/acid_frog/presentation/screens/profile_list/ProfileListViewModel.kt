package ajahn.dhsn.acid_frog.presentation.screens.profile_list

import ajahn.dhsn.acid_frog.data.database.entity.toAppProfile
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

@HiltViewModel
class ProfileListViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileListState())
    val state: StateFlow<ProfileListState> = _state.asStateFlow()

    init {
        getProfiles()
    }

    private fun getProfiles() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { currentState ->
                    currentState.copy(isLoading = true)
                }

                val response = profileRepository.getAll()

                when (response) {
                    is ResponseWrapper.Success -> {
                        _state.update { currentState ->
                            currentState.copy(
                                isLoading = false,
                                appProfiles = response.data ?: emptyList()
                            )
                        }
                    }

                    is ResponseWrapper.Error -> {
                        _state.update { currentState ->
                            currentState.copy(
                                isLoading = false,
                                error = response.errorMessage ?: "An unexpected error occurred"
                            )
                        }
                    }
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

    fun deleteAllProfiles(){
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