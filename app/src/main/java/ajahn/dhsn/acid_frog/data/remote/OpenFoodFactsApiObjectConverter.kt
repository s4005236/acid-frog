package ajahn.dhsn.acid_frog.data.remote

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import ajahn.dhsn.acid_frog.domain.model.AppProduct
import java.util.UUID

object OpenFoodFactsApiObjectConverter {
    fun productDto2AppProduct(productDto: ProductDto): AppProduct {
        return AppProduct(
            code = productDto.code,
            status = productDto.status,
            status_verbose = productDto.statusVerbose,
            name = "${productDto.product.brands} ${productDto.product.productNameDe}",
            ingredients = allergens2Ingredients(
                productDto.product.allergens,
                productDto.product.allergensFromIngredients
            )
        )
    }

    private fun allergens2Ingredients(vararg allergens: String): List<String> {
        val allergens = allergens.toList()
        val ingredients : List<String> = allergens
        return ingredients
    }
}