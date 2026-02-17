package ajahn.dhsn.acid_frog.data.repository

import ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApi
import ajahn.dhsn.acid_frog.data.remote.dto.Product
import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.ProductRepository
import jakarta.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: OpenFoodFactsApi
) : ProductRepository {

    override suspend fun getProductByCode(code: String): ResponseWrapper<ProductDto> {
        return try {
            val product = api.getProductByCode(code)
            ResponseWrapper.Success(product)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun getAllAllergens(): ResponseWrapper<List<String>> {
        return try {
            val allergens = api.getAllergens()
            ResponseWrapper.Success(allergens)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }
}