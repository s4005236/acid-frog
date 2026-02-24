package ajahn.dhsn.acid_frog.data.remote

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import ajahn.dhsn.acid_frog.domain.model.AppProduct

/**
 * Utility object for converting Open Food Facts API DTOs to application-specific models.
 *
 * This object provides conversion functions to transform API response objects into domain models
 * used within the application.
 */
object OpenFoodFactsApiObjectConverter {

    /**
     * Converts a [ProductDto] to an [AppProduct].
     *
     * This function maps the DTO's fields to the corresponding fields in [AppProduct],
     * including combining and processing allergen information.
     *
     * @param productDto The [ProductDto] to convert.
     * @return An [AppProduct] instance populated with data from [productDto].
     */
    fun productDto2AppProduct(productDto: ProductDto): AppProduct {
        return AppProduct(
            code = productDto.code,
            status = productDto.status,
            status_verbose = productDto.statusVerbose,
            name = "${productDto.product.brands} ${productDto.product.productNameDe}",
            ingredients = (productDto.product.allergens
                .split(",")
                    + productDto.product.allergensFromIngredients.split(","))
                .map {
                    it.trim().substringAfter(":")
                }
                .distinct()
                .filterNot { it.isEmpty() }
        )
    }
}
