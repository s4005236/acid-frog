package ajahn.dhsn.acid_frog.domain.repository.api

import ajahn.dhsn.acid_frog.domain.model.AppProduct
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper

/**
 * Repository interface for accessing product and allergen data.
 *
 * This interface defines methods to fetch product details by code and retrieve a list of known allergens.
 * Implementations are expected to handle network or database operations and return results wrapped in a [ResponseWrapper].
 */
interface ProductRepository {

    /**
     * Fetches a product by its unique code.
     *
     * @param code The unique identifier or barcode of the product.
     * @return A [ResponseWrapper] containing either the [AppProduct] or an error message.
     */
    suspend fun getProductByCode(code: String): ResponseWrapper<AppProduct>

    /**
     * Retrieves a list of all known allergens.
     *
     * @return A [ResponseWrapper] containing either the list of allergens or an error message.
     */
    suspend fun getAllAllergens(): ResponseWrapper<List<String>>
}
