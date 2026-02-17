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
            //TODO put real api method
            val product = ProductDto(
                code = "1234567890",
                product = Product(
                    productNameDe = "Milch"
                )
            )

            ResponseWrapper.Success(product)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun getAllAllergens(): ResponseWrapper<List<String>> {
        return try {
            //TODO put real api method
            val allergens = listOf("pepper", "paprika", "basil")

            ResponseWrapper.Success(allergens)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }
}