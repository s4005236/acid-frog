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

@HiltViewModel
class ProfileImportViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileImportState())
    val state: State<ProfileImportState> = _state

    init {
    }

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