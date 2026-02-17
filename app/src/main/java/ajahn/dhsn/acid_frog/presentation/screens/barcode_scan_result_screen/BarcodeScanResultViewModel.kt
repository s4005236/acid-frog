package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.repository.ProductRepository
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
class BarcodeScanResultViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = mutableStateOf(BarcodeScanResultState())
    val state: State<BarcodeScanResultState> = _state

    init {
    }

    fun getAppScanResult(productBarcode: String) {
        //TODO this should be restructured into "getScanResult"

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                //TODO begin processing data
                //get from repositories
                val appProduct = productRepository.getProductByCode(productBarcode).data?.product
                val appProfiles : List<AppProfile> = listOf(
                    AppProfile(
                        profileName = "test",
                        id ="12346",
                        allergens = emptyList(),
                        isActive = true
                    )
                )

                println(appProduct)

                //process



                //set state data , state loading = false
            }
        }
    }
}