package ajahn.dhsn.acid_frog.data.remote

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import ajahn.dhsn.acid_frog.domain.model.AppProduct
import java.util.UUID

object OpenFoodFactsApiObjectConverter {
    fun productDto2AppProduct(productDto: ProductDto): AppProduct {
        println(productDto)
        return AppProduct(
            code = productDto.code,
            status = productDto.status,
            status_verbose = productDto.statusVerbose,
            name = "${productDto.product.brands} ${productDto.product.productNameDe}",
            ingredients = (productDto.product.allergens
                .split(",")
                    + productDto.product.allergensFromIngredients.split(","))
                .map{
                    it.trim().substringAfter(":")
                }
                .distinct()
        )
    }
}