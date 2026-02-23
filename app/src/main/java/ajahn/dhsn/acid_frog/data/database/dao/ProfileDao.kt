package ajahn.dhsn.acid_frog.data.database.dao

import ajahn.dhsn.acid_frog.data.database.entity.ProfileEntity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

/**
 * Data Access Object (DAO) interface for managing [ProfileEntity] operations in the database.
 *
 * This interface provides methods to query, insert, update, and delete profile entities.
 * All suspend functions must be called from a coroutine or another suspending function.
 */
@Dao
interface ProfileDao {

    /**
     * Retrieves all profiles stored in the database.
     *
     * @return A [List] of [ProfileEntity] objects representing all profiles.
     */
    @Query("SELECT * FROM profiles")
    fun getAll(): List<ProfileEntity>

    /**
     * Retrieves a specific profile by its unique identifier.
     *
     * @param id The unique identifier of the profile to retrieve.
     * @return A [ProfileEntity] object representing the requested profile.
     * @throws Exception If the profile with the given [id] does not exist.
     */
    @Query("SELECT * FROM profiles WHERE id=:id")
    suspend fun getProfileById(id: Long): ProfileEntity

    /**
     * Inserts a new profile into the database.
     *
     * @param note The [ProfileEntity] object to insert.
     * @return The row ID of the newly inserted profile.
     * @throws SQLException If a conflict occurs (e.g., duplicate ID) due to [OnConflictStrategy.ABORT].
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertProfile(note: ProfileEntity): Long

    /**
     * Updates an existing profile or inserts it if it does not exist.
     *
     * @param note The [ProfileEntity] object to update or insert.
     */
    @Upsert
    suspend fun updateProfile(note: ProfileEntity)

    /**
     * Deletes a specific profile from the database.
     *
     * @param note The [ProfileEntity] object to delete.
     */
    @Delete
    suspend fun deleteProfile(note: ProfileEntity)

    /**
     * Deletes all profiles from the database.
     *
     * Use with caution, as this operation is irreversible.
     */
    @Query("DELETE FROM profiles")
    suspend fun deleteAll()
}
