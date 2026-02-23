package ajahn.dhsn.acid_frog.data.repository.room

import ajahn.dhsn.acid_frog.data.database.dao.ProfileDao
import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import ajahn.dhsn.acid_frog.data.database.entity.toAppProfile
import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper
import ajahn.dhsn.acid_frog.domain.repository.room.ProfileRepository

/**
 * Implementation of the [ProfileRepository] interface for managing profile data.
 *
 * This class uses a [ProfileDao] to perform database operations for profiles,
 * wrapping the results in a [ResponseWrapper] to handle success and error cases.
 *
 * @property dao The Data Access Object for profile operations.
 */
class ProfileRepositoryImpl(
    private val dao: ProfileDao
) : ProfileRepository {

    /**
     * Retrieves all profiles from the database.
     *
     * @return A [ResponseWrapper] containing either a list of [AppProfile] or an error message.
     */
    override suspend fun getAll(): ResponseWrapper<List<AppProfile>> {
        return try {
            val profile: List<AppProfile> = dao.getAll().map { it.toAppProfile() }
            ResponseWrapper.Success(profile)
        } catch (e: Exception) {
            ResponseWrapper.Error(e.message.toString())
        }
    }

    /**
     * Retrieves a profile by its unique identifier.
     *
     * If the provided [id] is `0L`, a new empty [AppProfile] is returned.
     * Otherwise, the existing profile is fetched from the database.
     *
     * @param id The unique identifier of the profile.
     * @return A [ResponseWrapper] containing either the [AppProfile] or an error message.
     */
    override suspend fun getProfileById(id: Long): ResponseWrapper<AppProfile> {
        return try {
            if (id == 0L) {
                // Create new profile
                ResponseWrapper.Success(AppProfile())
            } else {
                // Get existing profile
                val profile = dao.getProfileById(id)
                ResponseWrapper.Success(profile.toAppProfile())
            }
        } catch (e: Exception) {
            ResponseWrapper.Error(e.message.toString())
        }
    }

    /**
     * Inserts a new profile into the database.
     *
     * @param appProfile The [AppProfile] to insert.
     * @return A [ResponseWrapper] containing either the inserted profile's ID or an error message.
     */
    override suspend fun insertProfile(appProfile: AppProfile): ResponseWrapper<Long> {
        return try {
            val profileEntity = ProfileEntity.fromAppProfile(appProfile = appProfile)
            val profileId: Long = dao.insertProfile(profileEntity)
            ResponseWrapper.Success(profileId)
        } catch (e: Exception) {
            ResponseWrapper.Error(e.message.toString())
        }
    }

    /**
     * Updates an existing profile in the database.
     *
     * @param appProfile The [AppProfile] to update.
     */
    override suspend fun updateProfile(appProfile: AppProfile) {
        dao.updateProfile(ProfileEntity.fromAppProfile(appProfile))
    }

    /**
     * Deletes a profile from the database.
     *
     * @param appProfile The [AppProfile] to delete.
     */
    override suspend fun deleteProfile(appProfile: AppProfile) {
        dao.deleteProfile(ProfileEntity.fromAppProfile(appProfile))
    }

    /**
     * Deletes all profiles from the database.
     *
     * Use with caution, as this operation is irreversible.
     */
    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}
