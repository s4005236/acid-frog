package ajahn.dhsn.acid_frog.domain.repository

import ajahn.dhsn.acid_frog.data.remote.dto.ProductDto

interface ProductRepository {

    suspend fun getProductByCode(code: String): ProductDto
}