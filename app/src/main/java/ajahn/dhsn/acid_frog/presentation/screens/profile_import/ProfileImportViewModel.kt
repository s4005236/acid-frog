package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.SharableAppProfile
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
import androidx.core.net.toUri
import kotlinx.serialization.json.Json
import kotlin.Long

/**
 * ViewModel responsible for importing profiles from shared data strings.
 *
 * This ViewModel decodes a shared profile data string, converts it to an [AppProfile],
 * and inserts it into the repository. It exposes the state of the import operation through [state].
 *
 * @property profileRepository Repository for accessing and managing profile data.
 * @property state The current state of the profile import operation, exposed as a [State] object.
 */
@HiltViewModel
class ProfileImportViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileImportState())
    val state: State<ProfileImportState> = _state

    init {
    }

    /**
     * Imports a profile from a shared data string.
     *
     * This function:
     * 1. Extracts the JSON-encoded profile data from the provided string.
     * 2. Decodes the JSON into a [SharableAppProfile].
     * 3. Converts the sharable profile to an [AppProfile].
     * 4. Inserts the profile into the repository.
     * 5. Updates the state with the result.
     *
     * @param dataString The data string containing the encoded profile to import.
     */
    fun importProfileByDataString(dataString: String) {
        val uri = dataString.toUri()
        val jsonStringSharableAppProfile = uri.getQueryParameter("data") ?: return

        val sharableAppProfile: SharableAppProfile =
            Json.decodeFromString<SharableAppProfile>(jsonStringSharableAppProfile)
        val appProfile = AppProfile(
            id = mutableStateOf(0L),
            name = mutableStateOf(sharableAppProfile.name),
            allergens = sharableAppProfile.allergens.toMutableList(),
            isActive = mutableStateOf(sharableAppProfile.isActive),
        )

        if (state.value.importedProfileId == appProfile.id.value || state.value.importedProfileId == 0L) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    _state.value = state.value.copy(
                        isLoading = true
                    )

                    val response = profileRepository.insertProfile(appProfile)

                    _state.value = state.value.copy(
                        importedProfileId = response.data ?: 0L,
                        isLoading = false
                    )
                }
            }
        }
    }
}