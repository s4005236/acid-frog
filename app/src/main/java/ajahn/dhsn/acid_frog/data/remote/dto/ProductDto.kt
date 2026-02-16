package ajahn.dhsn.acid_frog.data.remote.dto


import ajahn.dhsn.acid_frog.domain.model.AppProduct
import com.google.gson.annotations.SerializedName
import java.util.UUID

data class ProductDto(
    @SerializedName("code")
    val code: String,
    @SerializedName("product")
    val product: Product,
    @SerializedName("status")
    val status: Int,
    @SerializedName("status_verbose")
    val statusVerbose: String
)

fun ProductDto.toAppProduct(): AppProduct {
    return AppProduct(
        id = UUID.randomUUID().toString(),
        code = code,
        status = status,
        status_verbose = statusVerbose,
        name = product.productName,
        //TODO get allergens for dto and convert to appProduct
        allergens = emptyList()
    )
}