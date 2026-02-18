package ajahn.dhsn.acid_frog.data.repository.room

import ajahn.dhsn.acid_frog.data.database.dao.ProfileDao
import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository

class ProfileRepositoryImpl(
    private val dao: ProfileDao
): ProfileRepository {
    override suspend fun getAll(): ResponseWrapper<List<ProfileEntity>> {
        return try {
            val profile = dao.getAll()
            ResponseWrapper.Success(profile)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun getProfileById(id: Long): ResponseWrapper<ProfileEntity> {
        return try {
            if (id == 0L){
                //create new profile
                ResponseWrapper.Success(ProfileEntity(
                    id = 0L,
                    name = "",
                    allergens = emptyList(),
                    isActive = false
                ))
            } else {
                //get existing profile
                val profile = dao.getProfileById(id)
                ResponseWrapper.Success(profile)
            }
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun insertProfile(profile: ProfileEntity): ResponseWrapper<Long> {
        return try {
            val profileId: Long = dao.insertProfile(profile)
            ResponseWrapper.Success(profileId)
        } catch(e: Exception){
            ResponseWrapper.Error(e.message.toString() )
        }
    }

    override suspend fun updateProfile(profile: ProfileEntity) {
        dao.updateProfile(profile)
    }

    override suspend fun deleteProfile(profile: ProfileEntity) {
        dao.deleteProfile(profile)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}