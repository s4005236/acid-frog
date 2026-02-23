package ajahn.dhsn.acid_frog.domain.repository.room

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import ajahn.dhsn.acid_frog.domain.model.ResponseWrapper

/**
 * Repository interface for managing profile data.
 *
 * This interface defines methods for retrieving, inserting, updating, and deleting profiles.
 * Implementations are expected to handle database operations and return results wrapped in a [ResponseWrapper]
 * where applicable.
 */
interface ProfileRepository {

    /**
     * Retrieves all profiles.
     *
     * @return A [ResponseWrapper] containing either a list of [AppProfile] or an error message.
     */
    suspend fun getAll(): ResponseWrapper<List<AppProfile>>

    /**
     * Retrieves a profile by its unique identifier.
     *
     * @param id The unique identifier of the profile.
     * @return A [ResponseWrapper] containing either the [AppProfile] or an error message.
     */
    suspend fun getProfileById(id: Long): ResponseWrapper<AppProfile>

    /**
     * Inserts a new profile.
     *
     * @param appProfile The [AppProfile] to insert.
     * @return A [ResponseWrapper] containing either the inserted profile's ID or an error message.
     */
    suspend fun insertProfile(appProfile: AppProfile): ResponseWrapper<Long>

    /**
     * Updates an existing profile.
     *
     * @param appProfile The [AppProfile] to update.
     */
    suspend fun updateProfile(appProfile: AppProfile)

    /**
     * Deletes a profile.
     *
     * @param appProfile The [AppProfile] to delete.
     */
    suspend fun deleteProfile(appProfile: AppProfile)

    /**
     * Deletes all profiles.
     *
     * Use with caution, as this operation is irreversible.
     */
    suspend fun deleteAll()
}
