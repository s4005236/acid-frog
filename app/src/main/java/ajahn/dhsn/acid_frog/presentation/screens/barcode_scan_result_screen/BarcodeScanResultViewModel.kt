package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.domain.Product
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.ProfileListState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import jakarta.inject.Inject

class BarcodeScanResultViewModel @Inject constructor(
    //TODO inject needed UseCases
    //private val getProfilesUseCase: GetProfilesUseCase
) : ViewModel(){

    private val _state = mutableStateOf(BarcodeScanResultState())
    val state: State<BarcodeScanResultState> = _state

    init {
    }

    fun getProduct(productBarcode: String){
        //FIXME this is a dummy element, change logic once domain layer is implemented

        val dummyProduct: Product = Product(
            id = "1",
            barcodeValue = "123456789",
            name = "Milch"
        )


        _state.value = BarcodeScanResultState(product = dummyProduct)
    }




}