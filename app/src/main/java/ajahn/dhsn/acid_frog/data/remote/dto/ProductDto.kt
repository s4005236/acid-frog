package ajahn.dhsn.acid_frog.data.remote.dto


import ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApiObjectConverter
import ajahn.dhsn.acid_frog.domain.model.AppProduct
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("code")
    val code: String = "",
    @SerializedName("product")
    val product: Product = Product(),
    @SerializedName("status")
    val status: Int = 0,
    @SerializedName("status_verbose")
    val statusVerbose: String = ""
)

fun ProductDto.toAppProduct(): AppProduct {
    return OpenFoodFactsApiObjectConverter.productDto2AppProduct(this)
}