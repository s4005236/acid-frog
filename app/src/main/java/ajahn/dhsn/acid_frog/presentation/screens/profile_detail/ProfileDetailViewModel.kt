package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import ajahn.dhsn.acid_frog.data.database.entity.toAppProfile
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
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
                            appProfile = response.data?.toAppProfile()
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

    fun saveProfile(profile: AppProfile) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                val profileEntity : ProfileEntity = ProfileEntity.fromAppProfile(profile)

                if (profile.id.value == 0L){
                    val response = profileRepository.insertProfile(profileEntity).data
                    //TODO what to do with the response
                } else {
                    val response = profileRepository.updateProfile(profileEntity)
                    //TODO what to do with the response
                }
            }
        }

        println("ID: ${profile.id}")
        println("Trying to save ${profile.name}")
        println("This includes the allergens ${profile.allergens}")
    }
}