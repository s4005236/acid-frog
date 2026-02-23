package ajahn.dhsn.acid_frog.presentation.screens.profile_detail

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.model.SharableAppProfile
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException
import java.net.URLEncoder
import androidx.core.net.toUri

/**
 * ViewModel responsible for managing profile details, including fetching, saving, deleting, and sharing profiles.
 *
 * This ViewModel coordinates the retrieval of allergen lists and profile data, handles profile operations,
 * and exposes the state of these operations to the UI through [state].
 *
 * @property productRepository Repository for accessing product and allergen data.
 * @property profileRepository Repository for accessing profile data.
 * @property state The current state of the profile detail operation, exposed as a [State] object.
 */
@HiltViewModel
class ProfileDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileDetailState())
    val state: State<ProfileDetailState> = _state

    init {
        // Fetch all allergens on initialization
        getAllAllergens()
    }

    /**
     * Fetches the list of all allergens.
     *
     * This function retrieves the list of allergens from the repository and updates the state accordingly.
     */
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
                        error = e.localizedMessage ?: "An unexpected error occurred"
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

    /**
     * Fetches a profile by its unique identifier.
     *
     * @param profileId The ID of the profile to fetch.
     */
    fun getProfile(profileId: Long) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(isLoading = true)

                val response = profileRepository.getProfileById(profileId)
                when (response) {
                    is ResponseWrapper.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            appProfile = response.data
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
     * Shares a profile via a sharable link.
     *
     * This function encodes the profile as a JSON string, creates a sharable link, and opens a share dialog.
     *
     * @param context The Android context for starting the share intent.
     * @param appProfile The profile to share.
     */
    fun shareProfile(context: Context, appProfile: AppProfile) {
        val sharableAppProfile = SharableAppProfile(
            id = appProfile.id.value,
            name = appProfile.name.value,
            allergens = appProfile.allergens,
            isActive = appProfile.isActive.value
        )

        val jsonAppProfile: String = Json.encodeToString(sharableAppProfile)
        val encodedAppProfile = URLEncoder.encode(jsonAppProfile, "UTF-8")
        val sharableLink = "app://acidfrog.app/share?data=$encodedAppProfile"

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, sharableLink)
        }
        context.startActivity(Intent.createChooser(shareIntent, "Per Link teilen"))
    }
}
