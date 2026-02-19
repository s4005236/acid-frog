package ajahn.dhsn.acid_frog.data.remote

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenFoodFactsApi {

    @GET("api/v2/product/{code}")
    suspend fun getProductByCode(@Path("code") code: String): ProductDto

    @GET("cgi/suggest.pl?tagtype=allergens")
    suspend fun getAllergens(): List<String>
}