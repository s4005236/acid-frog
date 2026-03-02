package ajahn.dhsn.acid_frog.data.remote

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface defining API endpoints for interacting with the Open Food Facts database.
 *
 * This interface provides suspend functions to fetch product details by code and retrieve a list of allergens.
 * All functions must be called from a coroutine or another suspending function.
 */
interface OpenFoodFactsApi {

    /**
     * Fetches a product by its unique code.
     *
     * @param code The unique identifier or barcode of the product.
     * @return A [ProductDto] containing the product details and response metadata.
     */
    @GET("api/v2/product/{code}")
    suspend fun getProductByCode(@Path("code") code: String): ProductDto

    /**
     * Retrieves a list of known allergens.
     *
     * @return A [List] of allergen names as strings.
     */
    @GET("cgi/suggest.pl?tagtype=allergens")
    suspend fun getAllergens(): List<String>
}