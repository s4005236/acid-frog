package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.model.AppProduct
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.AppScanResult
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository
import android.net.wifi.ScanResult
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

                //data retrieval

                var appProduct : AppProduct = AppProduct()
                var profiles : List<AppProfile> = emptyList()

                try {

                    val getProductResponse = productRepository.getProductByCode(productBarcode)

                    when (getProductResponse) {
                        is ResponseWrapper.Success -> {
                            appProduct = getProductResponse.data!!
                        }

                        is ResponseWrapper.Error -> {
                            _state.value = state.value.copy(
                                isLoading = false,
                                error = getProductResponse.errorMessage ?: "An unexpected error occurred"
                            )
                        }

                    }

                    val getAllProfilesResponse = profileRepository.getAll()

                    when (getAllProfilesResponse) {
                        is ResponseWrapper.Success -> {
                            profiles = getAllProfilesResponse.data!!
                        }

                        is ResponseWrapper.Error -> {
                            _state.value = state.value.copy(
                                isLoading = false,
                                error = getAllProfilesResponse.errorMessage ?: "An unexpected error occurred"
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


                //data processing

                var appScanResult : AppScanResult = AppScanResult()





                //TODO begin processing data
                //get from repositories
//                val appProduct: AppProduct? =
//                    productRepository.getProductByCode(productBarcode).data
                val responseAppProfiles = profileRepository.getAll()

                println("Received a appProduct from repo: ${appProduct}")
                println("Received a appProfile from repo: ${profiles}")

                println("set break point here")

                //process received data






                //set state data , state loading = false

                //set state
                _state.value = state.value.copy(
                    scanResult = appScanResult,
                    isLoading = false
                )

            }
        }
    }
}