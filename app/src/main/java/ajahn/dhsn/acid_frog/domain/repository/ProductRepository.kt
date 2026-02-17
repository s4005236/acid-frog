package ajahn.dhsn.acid_frog.domain.repository

import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto

interface ProductRepository {

    suspend fun getProductByCode(code: String): ResponseWrapper<ProductDto>

    suspend fun getAllAllergens() : ResponseWrapper<List<String>>
}