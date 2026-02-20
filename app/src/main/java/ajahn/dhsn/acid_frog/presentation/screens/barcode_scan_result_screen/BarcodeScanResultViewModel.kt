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

                var scannedAppProduct : AppProduct = AppProduct()
                var activeProfiles : List<AppProfile> = emptyList()

                try {

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
                var profileCounter : Int = 0

                println("\n\nLOG:####### DATA PROCESSING ########")

                scannedAppProduct.ingredients.forEach { ingredient->

                    println("\nLOG: NEUES INGREDIENT -----------------------")

                    println("LOG: Profile Counter Stand: ${profileCounter}")

                    println("LOG: Analysiere Ingredient: ${ingredient}")

                    val allergenProfileList : MutableList<AppProfile> = mutableListOf()

                    activeProfiles.forEach { profile ->
                        println("LOG: Analysiere Profil ${profile.name} auf ${ingredient}")

                        if(profile.allergens.any{
                            it.contains(ingredient, ignoreCase = true)
                        }){
                            println("LOG: Profile ${profile.name} enthält ${ingredient} und wird deswegen der allergenProfilListe hinzugefügt")
                            allergenProfileList.add(profile)
                        }
                    }

                    println("LOG: Dem AppScanResult wird folgende Map nun hinzugefügt: ${mapOf(
                        ingredient to allergenProfileList
                    )}")

                    if (allergenProfileList.isNotEmpty()){
                        profileCounter = profileCounter + allergenProfileList.size
                        appScanResult = appScanResult.copy(
                            scanResultMap = appScanResult.scanResultMap + mapOf(
                                ingredient to allergenProfileList
                            )
                        )
                    }
                }

                appScanResult = appScanResult.copy(
                    profileCount = profileCounter,
                    appProduct = scannedAppProduct
                )

                println(appScanResult)
                println("break stuff")


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