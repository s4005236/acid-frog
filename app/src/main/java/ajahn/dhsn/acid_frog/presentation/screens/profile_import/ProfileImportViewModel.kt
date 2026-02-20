package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository
import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileDetailState
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.PathSegment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLDecoder
import java.net.URLEncoder
import androidx.core.net.toUri
import com.google.gson.reflect.TypeToken

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
        val encodedData = uri.getQueryParameter("data") ?: return

        //TODO decode profile to import

        if (state.value.importedProfileId == appProfile.id.value || state.value.importedProfileId == 0L) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    _state.value = state.value.copy(
                        isLoading = true
                    )

                    val response = profileRepository.insertProfile(appProfile)

                    _state.value = state.value.copy(
                        importedProfileId = response.data!!,
                        isLoading = false
                    )
                }
            }
        }
    }
}