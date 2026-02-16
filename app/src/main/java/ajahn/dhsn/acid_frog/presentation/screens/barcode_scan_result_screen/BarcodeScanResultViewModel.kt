package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.common.Resource
import ajahn.dhsn.acid_frog.data.remote.dto.toAppProduct
import ajahn.dhsn.acid_frog.domain.model.AppProduct
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
import retrofit2.HttpException
import java.io.IOException

@HiltViewModel
class BarcodeScanResultViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = mutableStateOf(BarcodeScanResultState())
    val state: State<BarcodeScanResultState> = _state

    init {
    }

    fun getProduct(productBarcode: String) {
        viewModelScope.launch {
            _state.value = BarcodeScanResultState(
                isLoading = true
            )
            try {
                _state.value = BarcodeScanResultState(
                    appProduct = productRepository.getProductByCode(productBarcode).toAppProduct(),
                    isLoading = false
                )
            } catch (e: HttpException) {
                _state.value = BarcodeScanResultState(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occured"
                )
            } catch (e: IOException) {
                _state.value = BarcodeScanResultState(
                    error = "Couldn't reach server. Check your internet connection."
                )
            }
        }
    }
}