package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.model.AppProduct
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.AppScanResult
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

@HiltViewModel
class BarcodeScanResultViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(BarcodeScanResultState())
    val state: State<BarcodeScanResultState> = _state

    init {
    }

    fun getAppScanResult(productBarcode: String) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                //TODO begin processing data
                //get from repositories
                val appProduct: AppProduct? = productRepository.getProductByCode(productBarcode).data
                val appProfile : AppProfile? = profileRepository.getProfileById(1).data

                println("Received a appProduct from repo: ${appProduct}")
                println("Received a appProfile from repo: ${appProfile}")

                println("set break point here")

                //process received data



                //set state data , state loading = false



                _state.value = state.value.copy(
                    scanResult = AppScanResult(
                        profileCount = 23,
                        scanResultMap = mapOf(
                            "Milch" to listOf(
                                AppProfile(
                                    name = mutableStateOf("Michael")
                                ),
                                AppProfile(
                                    name = mutableStateOf("Claudia")
                                )
                            ),
                            "Gluten" to listOf(
                                AppProfile(
                                    name = mutableStateOf("Petra")
                                )
                        ),
                            "Gurke" to listOf(
                                AppProfile(
                                    name = mutableStateOf("Michael")
                                ),
                                AppProfile(
                                    name = mutableStateOf("Claudia")
                                )
                            ),
                            "Granatapfl" to listOf(
                                AppProfile(
                                    name = mutableStateOf("Petra")
                                )
                            ),
                            "Apfel" to listOf(
                                AppProfile(
                                    name = mutableStateOf("Michael")
                                ),
                                AppProfile(
                                    name = mutableStateOf("Claudia")
                                )
                            ),
                            "Banane" to listOf(
                                AppProfile(
                                    name = mutableStateOf("Petra")
                                )
                            )
                        ),
                        appProduct = appProduct ?: AppProduct()
                    ),
                    isLoading = false
                )

            }
        }
    }
}