package ajahn.dhsn.acid_frog.data.remote.dto


import ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApiObjectConverter
import ajahn.dhsn.acid_frog.domain.model.AppProduct
import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing a product response from an API.
 *
 * This class is used to deserialize JSON responses from product-related API calls.
 * It includes the product code, product details, status, and a verbose status description.
 *
 * @property code The unique identifier or code of the product.
 * @property product The [Product] object containing detailed product information.
 * @property status The HTTP or API status code associated with the response.
 * @property statusVerbose A human-readable description of the status.
 */
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

/**
 * Converts this [ProductDto] to an [AppProduct].
 *
 * This function delegates the conversion to [OpenFoodFactsApiObjectConverter.productDto2AppProduct].
 *
 * @return An [AppProduct] instance populated with data from this [ProductDto].
 */
fun ProductDto.toAppProduct(): AppProduct {
    return OpenFoodFactsApiObjectConverter.productDto2AppProduct(this)
}