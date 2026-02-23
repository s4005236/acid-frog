package ajahn.dhsn.acid_frog.data.repository.api

import ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApi
import ajahn.dhsn.acid_frog.data.remote.dto.toAppProduct
import ajahn.dhsn.acid_frog.domain.model.AppProduct
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.api.ProductRepository
import jakarta.inject.Inject

/**
 * Implementation of the [ProductRepository] interface for fetching product and allergen data.
 *
 * This class uses the [OpenFoodFactsApi] to retrieve product details and allergen lists,
 * wrapping the results in a [ResponseWrapper] to handle success and error cases.
 *
 * @property api The API service for Open Food Facts.
 */
class ProductRepositoryImpl @Inject constructor(
    private val api: OpenFoodFactsApi
) : ProductRepository {

    /**
     * Fetches a product by its unique code.
     *
     * @param code The unique identifier or barcode of the product.
     * @return A [ResponseWrapper] containing either the [AppProduct] or an error message.
     */
    override suspend fun getProductByCode(code: String): ResponseWrapper<AppProduct> {
        return try {
            val product = api.getProductByCode(code).toAppProduct()
            ResponseWrapper.Success(product)
        } catch (e: Exception) {
            ResponseWrapper.Error(e.message.toString())
        }
    }

    /**
     * Retrieves a list of all known allergens.
     *
     * @return A [ResponseWrapper] containing either the list of allergens or an error message.
     */
    override suspend fun getAllAllergens(): ResponseWrapper<List<String>> {
        return try {
            val allergens = api.getAllergens()
            ResponseWrapper.Success(allergens)
        } catch (e: Exception) {
            ResponseWrapper.Error(e.message.toString())
        }
    }
}
