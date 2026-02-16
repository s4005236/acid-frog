package ajahn.dhsn.acid_frog.data.repository

import ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApi
import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import ajahn.dhsn.acid_frog.domain.repository.ProductRepository
import jakarta.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: OpenFoodFactsApi
) : ProductRepository {

    override suspend fun getProductByCode(code: String): ProductDto {
        val product : ProductDto = api.getProductByCode(code)

        println("adfg")

        return product
    }
}