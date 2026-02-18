package ajahn.dhsn.acid_frog.data.repository.room

import ajahn.dhsn.acid_frog.data.database.dao.ProfileDao
import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import ajahn.dhsn.acid_frog.data.database.entity.toAppProfile
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository

class ProfileRepositoryImpl(
    private val dao: ProfileDao
): ProfileRepository {
    override suspend fun getAll(): ResponseWrapper<List<AppProfile>> {
        return try {
            val profile : List<AppProfile> = dao.getAll().map{
                AppProfile(it.id)
            }
            ResponseWrapper.Success(profile)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun getProfileById(id: Long): ResponseWrapper<AppProfile> {
        return try {
            if (id == 0L){
                //create new profile
                ResponseWrapper.Success(AppProfile(
                    id = 0L,
                    name = "",
                    allergens = emptyList(),
                    isActive = false
                ))
            } else {
                //get existing profile
                val profile = dao.getProfileById(id)
                ResponseWrapper.Success(profile.toAppProfile())
            }
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun insertProfile(appProfile: AppProfile): ResponseWrapper<Long> {
        return try {
            val profileEntity = ProfileEntity.fromAppProfile(appProfile = appProfile)
            val profileId: Long = dao.insertProfile(profileEntity)
            ResponseWrapper.Success(profileId)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun updateProfile(appProfile: AppProfile) {
        dao.updateProfile(ProfileEntity.fromAppProfile(appProfile))
    }

    override suspend fun deleteProfile(appProfile: AppProfile) {
        dao.deleteProfile(ProfileEntity.fromAppProfile(appProfile))
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}