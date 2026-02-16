package ajahn.dhsn.acid_frog.data.remote

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenFoodFactsApi {

    @GET("product/{code}")
    suspend fun getProductByCode(@Path("code") code: String) : ProductDto
}