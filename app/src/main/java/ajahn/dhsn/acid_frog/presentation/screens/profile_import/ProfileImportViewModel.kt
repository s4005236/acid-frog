package ajahn.dhsn.acid_frog.presentation.screens.profile_import

import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository
import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileDetailState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ProfileImportViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileDetailState())
    val state: State<ProfileDetailState> = _state

    init {
    }

    fun importProfileByDataString(dataString: String) {
        println(dataString)
    }
}