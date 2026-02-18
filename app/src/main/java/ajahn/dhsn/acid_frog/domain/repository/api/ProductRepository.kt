package ajahn.dhsn.acid_frog.domain.repository.api

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper

interface ProductRepository {

    suspend fun getProductByCode(code: String): ResponseWrapper<ProductDto>

    suspend fun getAllAllergens() : ResponseWrapper<List<String>>
}