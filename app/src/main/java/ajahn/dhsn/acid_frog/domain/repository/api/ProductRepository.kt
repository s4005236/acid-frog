package ajahn.dhsn.acid_frog.domain.repository.api

import ajahn.dhsn.acid_frog.domain.model.AppProduct
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper

interface ProductRepository {

    suspend fun getProductByCode(code: String): ResponseWrapper<AppProduct>

    suspend fun getAllAllergens() : ResponseWrapper<List<String>>
}