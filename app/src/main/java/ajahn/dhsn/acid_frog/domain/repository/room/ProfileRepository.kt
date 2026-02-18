package ajahn.dhsn.acid_frog.domain.repository.room

import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getAll(): ResponseWrapper<List<ProfileEntity>>
    suspend fun getProfileById(id: Long): ResponseWrapper<ProfileEntity>
    suspend fun insertProfile(profile: ProfileEntity) : ResponseWrapper<Long>
    suspend fun updateProfile(profile: ProfileEntity)
    suspend fun deleteProfile(profile: ProfileEntity)
    suspend fun deleteAll()
}