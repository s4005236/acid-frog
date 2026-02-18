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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

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
                _state.value = state.value.copy(
                        isLoading = true
                    )

                    val response = profileRepository.getAll()

                    when (response) {
                        is ResponseWrapper.Success -> {
                            _state.value = state.value.copy(
                                isLoading = false,
                                appProfiles = response.data?.map {
                                    it.toAppProfile()
                                } ?: emptyList()
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
}