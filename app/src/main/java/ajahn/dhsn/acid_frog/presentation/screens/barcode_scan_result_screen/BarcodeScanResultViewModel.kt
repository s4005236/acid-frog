package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.model.AppProduct
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.AppScanResult
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

/**
 * ViewModel responsible for managing barcode scan results and processing allergen matches.
 *
 * This ViewModel fetches product details and active profiles, checks for allergen conflicts,
 * and updates the UI state with the results. It uses coroutines for asynchronous operations
 * and exposes the state via [state].
 *
 * @property productRepository Repository for accessing product data.
 * @property profileRepository Repository for accessing profile data.
 * @property state The current state of the barcode scan result operation, exposed as a [State] object.
 */
@HiltViewModel
class BarcodeScanResultViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(BarcodeScanResultState())
    val state: State<BarcodeScanResultState> = _state

    /**
     * Fetches and processes the scan result for a product identified by its barcode.
     *
     * This function:
     * 1. Sets the loading state.
     * 2. Retrieves product details and active profiles.
     * 3. Checks for allergen matches between the product and profiles.
     * 4. Updates the state with the result.
     *
     * @param productBarcode The barcode of the product to scan.
     */
    fun getAppScanResult(productBarcode: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = state.value.copy(
                    isLoading = true
                )

                // Data retrieval
                var scannedAppProduct: AppProduct = AppProduct()
                var activeProfiles: List<AppProfile> = emptyList()

                try {
                    // Fetch product details
                    val getProductResponse = productRepository.getProductByCode(productBarcode)
                    when (getProductResponse) {
                        is ResponseWrapper.Success -> {
                            scannedAppProduct = getProductResponse.data ?: AppProduct()
                        }
                        is ResponseWrapper.Error -> {
                            _state.value = state.value.copy(
                                isLoading = false,
                                error = getProductResponse.errorMessage ?: "An unexpected error occurred"
                            )
                        }
                    }

                    // Fetch active profiles
                    val getAllProfilesResponse = profileRepository.getAll()
                    when (getAllProfilesResponse) {
                        is ResponseWrapper.Success -> {
                            activeProfiles = getAllProfilesResponse.data?.filter { it.isActive.value } ?: emptyList()
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
                        error = e.localizedMessage ?: "An unexpected error occurred"
                    )
                } catch (e: IOException) {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = "Couldn't reach server. Check your internet connection."
                    )
                }

                // Data processing
                var appScanResult: AppScanResult = AppScanResult()
                /** List used for calculating [AppScanResult.profileCount] */
                val affectedProfiles: MutableList<AppProfile> = mutableListOf()

                scannedAppProduct.ingredients.forEach { ingredient ->
                    val allergenProfileList: MutableList<AppProfile> = mutableListOf()

                    activeProfiles.forEach { profile ->
                        if (profile.allergens.any { it.contains(ingredient, ignoreCase = true) }) {
                            allergenProfileList.add(profile)
                        }
                    }

                    if (allergenProfileList.isNotEmpty()) {
                        affectedProfiles.addAll(allergenProfileList)
                        appScanResult = appScanResult.copy(
                            scanResultMap = appScanResult.scanResultMap + mapOf(
                                ingredient to allergenProfileList
                            )
                        )
                    }
                }

                appScanResult = appScanResult.copy(
                    profileCount = affectedProfiles.distinct().size,
                    appProduct = scannedAppProduct
                )

                // Set state
                _state.value = state.value.copy(
                    scanResult = appScanResult,
                    isLoading = false
                )
            }
        }
    }
}
