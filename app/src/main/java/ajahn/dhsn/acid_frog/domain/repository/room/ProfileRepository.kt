package ajahn.dhsn.acid_frog.domain.repository.room

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper

interface ProfileRepository {
    suspend fun getAll(): ResponseWrapper<List<AppProfile>>
    suspend fun getProfileById(id: Long): ResponseWrapper<AppProfile>
    suspend fun insertProfile(appProfile: AppProfile) : ResponseWrapper<Long>
    suspend fun updateProfile(appProfile: AppProfile)
    suspend fun deleteProfile(appProfile: AppProfile)
    suspend fun deleteAll()
}